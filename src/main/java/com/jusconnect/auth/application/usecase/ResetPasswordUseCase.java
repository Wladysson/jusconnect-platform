package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.jusconnect.auth.application.dto.request.ResetPasswordRequest;
import com.jusconnect.auth.infrastructure.security.PasswordEncoder;
import com.jusconnect.auth.domain.model.PasswordResetToken;
import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.domain.repository.AuthRepository;
import com.jusconnect.auth.domain.repository.PasswordResetRepository;

@ApplicationScoped
public class ResetPasswordUseCase {

    @Inject
    PasswordResetRepository passwordResetRepository;

    @Inject
    AuthRepository authRepository;

    @Inject
    PasswordEncoder passwordEncoder;

    public void execute(
            ResetPasswordRequest request
    ) {

        PasswordResetToken token =
                passwordResetRepository.findByToken(
                        request.token()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Token inválido"
                        )
                );

        if (token.isExpired()) {
            throw new RuntimeException(
                    "Token expirado"
            );
        }

        UserCredential user =
                authRepository.findById(
                        token.getUserCredentialId()
                ).orElseThrow();

        user.setPasswordHash(
                passwordEncoder.encode(
                        request.newPassword()
                )
        );

        authRepository.update(user);

        passwordResetRepository.deleteById(
                token.getId()
        );
    }
}
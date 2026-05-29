package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.jusconnect.auth.domain.model.PasswordResetToken;
import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.domain.repository.AuthRepository;
import com.jusconnect.auth.domain.repository.PasswordResetRepository;
import com.jusconnect.auth.application.dto.request.ForgotPasswordRequest;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class ForgotPasswordUseCase {

    @Inject
    AuthRepository authRepository;

    @Inject
    PasswordResetRepository passwordResetRepository;

    public void execute(
            ForgotPasswordRequest request
    ) {

        UserCredential user =
                authRepository.findByEmail(request.getEmail())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Usuário não encontrado"
                                )
                        );

        passwordResetRepository.revokeAllByUserCredentialId(
                user.getId()
        );

        PasswordResetToken token =
                new PasswordResetToken(
                        UUID.randomUUID(),
                        user.getId(),
                        UUID.randomUUID().toString(),
                        LocalDateTime.now().plusHours(1),
                        null
                );

        passwordResetRepository.save(token);

        // futuro NotificationClient
    }
}
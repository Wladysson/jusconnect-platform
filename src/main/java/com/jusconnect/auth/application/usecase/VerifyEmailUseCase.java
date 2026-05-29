package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.jusconnect.auth.application.dto.request.VerifyEmailRequest;
import com.jusconnect.auth.domain.model.EmailVerificationToken;
import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.domain.repository.AuthRepository;
import com.jusconnect.auth.domain.repository.EmailVerificationRepository;

@ApplicationScoped
public class VerifyEmailUseCase {

    @Inject
    EmailVerificationRepository repository;

    @Inject
    AuthRepository authRepository;

    public void execute(
            VerifyEmailRequest request
    ) {

        EmailVerificationToken token =
                repository.findByToken(
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

        user.setEmailVerified(true);

        authRepository.update(user);

        repository.deleteById(
                token.getId()
        );
    }
}
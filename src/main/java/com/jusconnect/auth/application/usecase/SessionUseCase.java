package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.jusconnect.auth.application.dto.response.SessionResponse;
import com.jusconnect.auth.domain.model.RefreshToken;
import com.jusconnect.auth.domain.repository.TokenRepository;

import java.util.UUID;

@ApplicationScoped
public class SessionUseCase {

    @Inject
    TokenRepository tokenRepository;

    public SessionResponse execute(
            UUID userCredentialId
    ) {

        RefreshToken token =
                tokenRepository.findActiveByUserCredentialId(
                        userCredentialId
                ).orElse(null);

        if (token == null) {
            return null;
        }

        return new SessionResponse(
                token.getId(),
                token.getCreatedAt(),
                token.getExpiresAt(),
                token.getStatus().name()
        );
    }
}
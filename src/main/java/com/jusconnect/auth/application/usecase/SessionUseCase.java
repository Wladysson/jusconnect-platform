package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.auth.application.dto.response.SessionResponse;
import com.jusconnect.auth.domain.model.RefreshToken;
import com.jusconnect.auth.domain.repository.TokenRepository;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class SessionUseCase {

    @Inject
    TokenRepository tokenRepository;

    public SessionResponse execute(
            UUID userCredentialId
    ) {

        List<RefreshToken> tokens =
                tokenRepository
                        .findActiveByUserCredentialId(
                                userCredentialId
                        );

        if (tokens.isEmpty()) {
            return null;
        }

        RefreshToken token = tokens.get(0);

        return new SessionResponse(
                token.getId(),
                "Unknown Device",
                "0.0.0.0",
                token.getCreatedAt(),
                token.getExpiresAt(),
                true
        );
    }
}
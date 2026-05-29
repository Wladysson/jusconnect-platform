package com.jusconnect.auth.domain.repository;

import com.jusconnect.auth.domain.model.RefreshToken;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository {

    Optional<RefreshToken> findByToken(String token);

    RefreshToken save(RefreshToken refreshToken);

    void revokeAllByUserCredentialId(UUID userCredentialId);

    void deleteExpiredTokens();

    List<RefreshToken> findByUserCredentialId(
            UUID userCredentialId
    );

    List<RefreshToken> findActiveByUserCredentialId(
            UUID userCredentialId
    );
}
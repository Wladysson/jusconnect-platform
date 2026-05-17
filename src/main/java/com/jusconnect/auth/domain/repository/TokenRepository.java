package com.jusconnect.auth.domain.repository;

import jusconnect.auth.domain.model.RefreshToken;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepository {

    Optional<RefreshToken> findByToken(String token);

    RefreshToken save(RefreshToken refreshToken);

    void revokeAllByUserCredentialId(UUID userCredentialId);

    void deleteExpiredTokens();

}
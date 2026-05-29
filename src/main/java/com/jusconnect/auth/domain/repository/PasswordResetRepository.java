package com.jusconnect.auth.domain.repository;

import com.jusconnect.auth.domain.model.PasswordResetToken;

import java.util.Optional;
import java.util.UUID;

public interface PasswordResetRepository {

    void save(PasswordResetToken token);

    Optional<PasswordResetToken> findByToken(String token);

    Optional<PasswordResetToken> findByUserCredentialId(
            UUID userCredentialId
    );

    void deleteById(UUID id);

    void revokeAllByUserCredentialId(
            UUID userCredentialId
    );
}
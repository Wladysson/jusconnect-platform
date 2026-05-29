package com.jusconnect.auth.domain.repository;

import com.jusconnect.auth.domain.model.EmailVerificationToken;

import java.util.Optional;
import java.util.UUID;

public interface EmailVerificationRepository {

    void save(EmailVerificationToken token);

    Optional<EmailVerificationToken> findByToken(
            String token
    );

    Optional<EmailVerificationToken> findByUserCredentialId(
            UUID userCredentialId
    );

    void deleteById(UUID id);

    void revokeAllByUserCredentialId(
            UUID userCredentialId
    );
}
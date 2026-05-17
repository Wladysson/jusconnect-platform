package com.jusconnect.auth.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import com.jusconnect.auth.domain.model.RefreshToken;
import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.domain.repository.AuthRepository;
import com.jusconnect.auth.domain.repository.TokenRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class AuthDomainService {

    private final AuthRepository authRepository;

    private final TokenRepository tokenRepository;

    public AuthDomainService(
            AuthRepository authRepository,
            TokenRepository tokenRepository
    ) {
        this.authRepository = authRepository;
        this.tokenRepository = tokenRepository;
    }

    public UserCredential validateCredentials(
            String email,
            String passwordHash
    ) {

        UserCredential credential = authRepository.findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid credentials")
                );

        if (!credential.isActive()) {
            throw new IllegalStateException("User is inactive");
        }

        if (!credential.getPasswordHash().equals(passwordHash)) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        credential.updateLastLogin();

        return credential;
    }

    public RefreshToken createRefreshToken(UUID userCredentialId) {

        RefreshToken refreshToken = new RefreshToken(
                UUID.randomUUID(),
                userCredentialId,
                UUID.randomUUID().toString(),
                LocalDateTime.now().plusDays(7)
        );

        return tokenRepository.save(refreshToken);
    }

    public void revokeUserTokens(UUID userCredentialId) {
        tokenRepository.revokeAllByUserCredentialId(userCredentialId);
    }

}
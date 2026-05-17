package com.jusconnect.auth.domain.model;

import com.jusconnect.auth.domain.enums.TokenStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class RefreshToken {

    private UUID id;

    private UUID userCredentialId;

    private String token;

    private TokenStatus status;

    private LocalDateTime expiresAt;

    private LocalDateTime createdAt;

    private LocalDateTime revokedAt;

    public RefreshToken() {
    }

    public RefreshToken(
            UUID id,
            UUID userCredentialId,
            String token,
            LocalDateTime expiresAt
    ) {
        this.id = id;
        this.userCredentialId = userCredentialId;
        this.token = token;
        this.expiresAt = expiresAt;
        this.status = TokenStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiresAt);
    }

    public boolean isActive() {
        return status == TokenStatus.ACTIVE;
    }

    public void revoke() {
        this.status = TokenStatus.REVOKED;
        this.revokedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserCredentialId() {
        return userCredentialId;
    }

    public String getToken() {
        return token;
    }

    public TokenStatus getStatus() {
        return status;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getRevokedAt() {
        return revokedAt;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUserCredentialId(UUID userCredentialId) {
        this.userCredentialId = userCredentialId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(TokenStatus status) {
        this.status = status;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setRevokedAt(LocalDateTime revokedAt) {
        this.revokedAt = revokedAt;
    }
}
package com.jusconnect.auth.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class PasswordResetToken {

    private UUID id;

    private UUID userCredentialId;

    private String token;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private LocalDateTime usedAt;

    public PasswordResetToken() {
    }

    public PasswordResetToken(
            UUID id,
            UUID userCredentialId,
            String token,
            LocalDateTime createdAt,
            LocalDateTime expiresAt
    ) {
        this.id = id;
        this.userCredentialId = userCredentialId;
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    public boolean isExpired() {
        return expiresAt != null &&
                LocalDateTime.now().isAfter(expiresAt);
    }

    public boolean isUsed() {
        return usedAt != null;
    }

    public boolean isValid() {
        return !isExpired() && !isUsed();
    }

    public void markAsUsed() {
        this.usedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserCredentialId() {
        return userCredentialId;
    }

    public void setUserCredentialId(
            UUID userCredentialId
    ) {
        this.userCredentialId = userCredentialId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(
            String token
    ) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(
            LocalDateTime createdAt
    ) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(
            LocalDateTime expiresAt
    ) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(
            LocalDateTime usedAt
    ) {
        this.usedAt = usedAt;
    }
}
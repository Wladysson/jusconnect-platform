package com.jusconnect.auth.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class EmailVerificationToken {

    private UUID id;

    private UUID userCredentialId;

    private String token;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private LocalDateTime verifiedAt;

    public EmailVerificationToken() {
    }

    public EmailVerificationToken(
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

    public boolean isVerified() {
        return verifiedAt != null;
    }

    public boolean isValid() {
        return !isExpired() && !isVerified();
    }

    public void markAsVerified() {
        this.verifiedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
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

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(
            LocalDateTime verifiedAt
    ) {
        this.verifiedAt = verifiedAt;
    }
}
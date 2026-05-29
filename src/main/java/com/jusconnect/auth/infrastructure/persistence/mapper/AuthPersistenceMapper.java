package com.jusconnect.auth.infrastructure.persistence.mapper;

import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.domain.model.RefreshToken;
import com.jusconnect.auth.domain.model.PasswordResetToken;
import com.jusconnect.auth.domain.model.EmailVerificationToken;

import com.jusconnect.auth.infrastructure.persistence.entity.UserCredentialEntity;
import com.jusconnect.auth.infrastructure.persistence.entity.RefreshTokenEntity;
import com.jusconnect.auth.infrastructure.persistence.entity.PasswordResetTokenEntity;
import com.jusconnect.auth.infrastructure.persistence.entity.EmailVerificationTokenEntity;

@ApplicationScoped
public class AuthPersistenceMapper {

    // =========================
    // USER CREDENTIAL
    // =========================

    public UserCredential toDomain(UserCredentialEntity entity) {
        if (entity == null) return null;

        UserCredential domain = new UserCredential();

        domain.setId(entity.id);
        domain.setUserId(entity.userId);
        domain.setEmail(entity.email);
        domain.setPasswordHash(entity.passwordHash);

        domain.setActive(entity.active);
        domain.setEmailVerified(entity.emailVerified);

        domain.setCreatedAt(entity.createdAt);
        domain.setUpdatedAt(entity.updatedAt);
        domain.setLastLoginAt(entity.lastLoginAt);

        return domain;
    }

    public UserCredentialEntity toEntity(UserCredential domain) {
        if (domain == null) return null;

        UserCredentialEntity entity = new UserCredentialEntity();

        entity.id = domain.getId();
        entity.userId = domain.getUserId();
        entity.email = domain.getEmail();
        entity.passwordHash = domain.getPasswordHash();

        entity.active = domain.isActive();
        entity.emailVerified = domain.isEmailVerified();

        entity.createdAt = domain.getCreatedAt();
        entity.updatedAt = domain.getUpdatedAt();
        entity.lastLoginAt = domain.getLastLoginAt();

        return entity;
    }

    // =========================
    // REFRESH TOKEN
    // =========================

    public RefreshToken toDomain(RefreshTokenEntity entity) {
        if (entity == null) return null;

        RefreshToken domain = new RefreshToken();

        domain.setId(entity.id);
        domain.setUserCredentialId(entity.userCredentialId);
        domain.setToken(entity.token);
        domain.setStatus(entity.status);

        domain.setCreatedAt(entity.createdAt);
        domain.setExpiresAt(entity.expiresAt);
        domain.setRevokedAt(entity.revokedAt);

        return domain;
    }

    public RefreshTokenEntity toEntity(RefreshToken domain) {
        if (domain == null) return null;

        RefreshTokenEntity entity = new RefreshTokenEntity();

        entity.id = domain.getId();
        entity.userCredentialId = domain.getUserCredentialId();
        entity.token = domain.getToken();
        entity.status = domain.getStatus();

        entity.createdAt = domain.getCreatedAt();
        entity.expiresAt = domain.getExpiresAt();
        entity.revokedAt = domain.getRevokedAt();

        return entity;
    }

    // =========================
    // PASSWORD RESET
    // =========================

    public PasswordResetToken toDomain(PasswordResetTokenEntity entity) {
        if (entity == null) return null;

        PasswordResetToken domain = new PasswordResetToken();

        domain.setId(entity.id);
        domain.setUserCredentialId(entity.userCredentialId);
        domain.setToken(entity.token);
        domain.setCreatedAt(entity.createdAt);
        domain.setExpiresAt(entity.expiresAt);
        domain.setUsedAt(entity.usedAt);

        return domain;
    }

    public PasswordResetTokenEntity toEntity(PasswordResetToken domain) {
        if (domain == null) return null;

        PasswordResetTokenEntity entity = new PasswordResetTokenEntity();

        entity.id = domain.getId();
        entity.userCredentialId = domain.getUserCredentialId();
        entity.token = domain.getToken();
        entity.createdAt = domain.getCreatedAt();
        entity.expiresAt = domain.getExpiresAt();
        entity.usedAt = domain.getUsedAt();

        return entity;
    }

    // =========================
    // EMAIL VERIFICATION
    // =========================

    public EmailVerificationToken toDomain(EmailVerificationTokenEntity entity) {
        if (entity == null) return null;

        EmailVerificationToken domain = new EmailVerificationToken();

        domain.setId(entity.id);
        domain.setUserCredentialId(entity.userCredentialId);
        domain.setToken(entity.token);
        domain.setCreatedAt(entity.createdAt);
        domain.setExpiresAt(entity.expiresAt);
        domain.setVerifiedAt(entity.verifiedAt);

        return domain;
    }

    public EmailVerificationTokenEntity toEntity(EmailVerificationToken domain) {
        if (domain == null) return null;

        EmailVerificationTokenEntity entity = new EmailVerificationTokenEntity();

        entity.id = domain.getId();
        entity.userCredentialId = domain.getUserCredentialId();
        entity.token = domain.getToken();
        entity.createdAt = domain.getCreatedAt();
        entity.expiresAt = domain.getExpiresAt();
        entity.verifiedAt = domain.getVerifiedAt();

        return entity;
    }
}
package com.jusconnect.auth.infrastructure.persistence.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import com.jusconnect.auth.domain.model.RefreshToken;
import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.infrastructure.persistence.entity.RefreshTokenEntity;
import com.jusconnect.auth.infrastructure.persistence.entity.UserCredentialEntity;

@ApplicationScoped
public class AuthPersistenceMapper {

    public UserCredential toDomain(UserCredentialEntity entity) {

        UserCredential domain = new UserCredential();

        domain.setId(entity.id);
        domain.setUserId(entity.userId);
        domain.setEmail(entity.email);
        domain.setPasswordHash(entity.passwordHash);

        domain.setCreatedAt(entity.createdAt);
        domain.setUpdatedAt(entity.updatedAt);

        return domain;
    }

    public UserCredentialEntity toEntity(UserCredential domain) {

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

    public RefreshToken toDomain(RefreshTokenEntity entity) {

        RefreshToken domain = new RefreshToken();

        domain.setId(entity.id);
        domain.setUserCredentialId(entity.userCredentialId);
        domain.setToken(entity.token);
        domain.setStatus(entity.status);

        domain.setExpiresAt(entity.expiresAt);
        domain.setCreatedAt(entity.createdAt);
        domain.setRevokedAt(entity.revokedAt);

        return domain;
    }

    public RefreshTokenEntity toEntity(RefreshToken domain) {

        RefreshTokenEntity entity = new RefreshTokenEntity();

        entity.id = domain.getId();
        entity.userCredentialId = domain.getUserCredentialId();
        entity.token = domain.getToken();
        entity.status = domain.getStatus();

        entity.expiresAt = domain.getExpiresAt();
        entity.createdAt = domain.getCreatedAt();
        entity.revokedAt = domain.getRevokedAt();

        return entity;
    }
}
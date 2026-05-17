package com.jusconnect.auth.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import com.jusconnect.auth.domain.enums.TokenStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "refresh_tokens")
public class RefreshTokenEntity extends PanacheEntityBase {

    @Id
    @Column(nullable = false, updatable = false)
    public UUID id;

    @Column(name = "user_credential_id", nullable = false)
    public UUID userCredentialId;

    @Column(nullable = false, unique = true, length = 1000)
    public String token;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public TokenStatus status;

    @Column(name = "expires_at")
    public LocalDateTime expiresAt;

    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @Column(name = "revoked_at")
    public LocalDateTime revokedAt;

}
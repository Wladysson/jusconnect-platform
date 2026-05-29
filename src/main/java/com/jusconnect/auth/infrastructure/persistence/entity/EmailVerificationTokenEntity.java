package com.jusconnect.auth.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "email_verification_tokens")
public class EmailVerificationTokenEntity extends PanacheEntityBase {

    @Id
    public UUID id;

    @Column(name = "user_credential_id", nullable = false)
    public UUID userCredentialId;

    @Column(nullable = false, unique = true)
    public String token;

    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @Column(name = "expires_at")
    public LocalDateTime expiresAt;

    @Column(name = "verified_at")
    public LocalDateTime verifiedAt;
}
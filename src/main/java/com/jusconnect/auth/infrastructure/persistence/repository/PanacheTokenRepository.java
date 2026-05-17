package com.jusconnect.auth.infrastructure.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jusconnect.auth.domain.enums.TokenStatus;
import jusconnect.auth.domain.model.RefreshToken;
import jusconnect.auth.domain.repository.TokenRepository;
import jusconnect.auth.infrastructure.persistence.entity.RefreshTokenEntity;
import jusconnect.auth.infrastructure.persistence.mapper.AuthPersistenceMapper;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheTokenRepository
        implements TokenRepository, PanacheRepository<RefreshTokenEntity> {

    private final AuthPersistenceMapper mapper;

    public PanacheTokenRepository(AuthPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Optional<RefreshToken> findByToken(String token) {

        return find("token", token)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    @Transactional
    public RefreshToken save(RefreshToken refreshToken) {

        RefreshTokenEntity entity = mapper.toEntity(refreshToken);

        persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    @Transactional
    public void revokeAllByUserCredentialId(UUID userCredentialId) {

        update(
                "status = ?1 where userCredentialId = ?2",
                TokenStatus.REVOKED,
                userCredentialId
        );
    }

    @Override
    @Transactional
    public void deleteExpiredTokens() {

        delete(
                "expiresAt < ?1",
                LocalDateTime.now()
        );
    }
}
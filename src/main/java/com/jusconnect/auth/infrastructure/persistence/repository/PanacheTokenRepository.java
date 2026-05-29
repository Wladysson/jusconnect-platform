package com.jusconnect.auth.infrastructure.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import com.jusconnect.auth.domain.enums.TokenStatus;
import com.jusconnect.auth.domain.model.RefreshToken;
import com.jusconnect.auth.domain.repository.TokenRepository;
import com.jusconnect.auth.infrastructure.persistence.entity.RefreshTokenEntity;
import com.jusconnect.auth.infrastructure.persistence.mapper.AuthPersistenceMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheTokenRepository
        implements TokenRepository,
        PanacheRepository<RefreshTokenEntity> {

    private final AuthPersistenceMapper mapper;

    public PanacheTokenRepository(
            AuthPersistenceMapper mapper
    ) {
        this.mapper = mapper;
    }

    @Override
    public Optional<RefreshToken> findByToken(
            String token
    ) {

        return find(
                "token",
                token
        )
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public List<RefreshToken> findByUserCredentialId(
            UUID userCredentialId
    ) {

        return find(
                "userCredentialId",
                userCredentialId
        )
                .list()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<RefreshToken> findActiveByUserCredentialId(
            UUID userCredentialId
    ) {

        return find(
                "userCredentialId = ?1 and status = ?2",
                userCredentialId,
                TokenStatus.ACTIVE
        )
                .list()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public RefreshToken save(
            RefreshToken refreshToken
    ) {

        RefreshTokenEntity entity =
                mapper.toEntity(refreshToken);

        persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    @Transactional
    public void revokeAllByUserCredentialId(
            UUID userCredentialId
    ) {

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
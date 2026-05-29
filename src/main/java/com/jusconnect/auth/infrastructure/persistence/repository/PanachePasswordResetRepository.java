package com.jusconnect.auth.infrastructure.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import com.jusconnect.auth.domain.model.PasswordResetToken;
import com.jusconnect.auth.domain.repository.PasswordResetRepository;
import com.jusconnect.auth.infrastructure.persistence.entity.PasswordResetTokenEntity;
import com.jusconnect.auth.infrastructure.persistence.mapper.AuthPersistenceMapper;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanachePasswordResetRepository
        implements PasswordResetRepository,
        PanacheRepository<PasswordResetTokenEntity> {

    @Inject
    AuthPersistenceMapper mapper;

    @Override
    @Transactional
    public void save(
            PasswordResetToken token
    ) {

        PasswordResetTokenEntity entity =
                mapper.toEntity(token);

        persist(entity);
    }

    @Override
    public Optional<PasswordResetToken> findByToken(
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
    public Optional<PasswordResetToken> findByUserCredentialId(
            UUID userCredentialId
    ) {

        return find(
                "userCredentialId",
                userCredentialId
        )
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    @Transactional
    public void deleteById(
            UUID id
    ) {

        delete(
                "id",
                id
        );
    }

    @Override
    @Transactional
    public void revokeAllByUserCredentialId(
            UUID userCredentialId
    ) {

        update(
                "usedAt = ?1 where userCredentialId = ?2 and usedAt is null",
                LocalDateTime.now(),
                userCredentialId
        );
    }
}
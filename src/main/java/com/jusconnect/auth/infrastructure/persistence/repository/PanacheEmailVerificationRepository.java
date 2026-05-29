package com.jusconnect.auth.infrastructure.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import com.jusconnect.auth.domain.model.EmailVerificationToken;
import com.jusconnect.auth.domain.repository.EmailVerificationRepository;
import com.jusconnect.auth.infrastructure.persistence.entity.EmailVerificationTokenEntity;
import com.jusconnect.auth.infrastructure.persistence.mapper.AuthPersistenceMapper;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheEmailVerificationRepository
        implements EmailVerificationRepository,
        PanacheRepository<EmailVerificationTokenEntity> {

    @Inject
    AuthPersistenceMapper mapper;

    @Override
    @Transactional
    public void save(
            EmailVerificationToken token
    ) {

        EmailVerificationTokenEntity entity =
                mapper.toEntity(token);

        persist(entity);
    }

    @Override
    public Optional<EmailVerificationToken> findByToken(
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
    public Optional<EmailVerificationToken> findByUserCredentialId(
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
                "verifiedAt = ?1 where userCredentialId = ?2",
                LocalDateTime.now(),
                userCredentialId
        );
    }
}
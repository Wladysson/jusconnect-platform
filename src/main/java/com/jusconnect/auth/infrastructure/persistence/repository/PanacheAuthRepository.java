package com.jusconnect.auth.infrastructure.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.domain.repository.AuthRepository;
import com.jusconnect.auth.infrastructure.persistence.entity.UserCredentialEntity;
import com.jusconnect.auth.infrastructure.persistence.mapper.AuthPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheAuthRepository
        implements AuthRepository, PanacheRepository<UserCredentialEntity> {

    private final AuthPersistenceMapper mapper;

    public PanacheAuthRepository(AuthPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Optional<UserCredential> findById(UUID id) {

        return find("id", id)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public Optional<UserCredential> findByEmail(String email) {

        return find("email", email)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }

    @Override
    @Transactional
    public UserCredential save(UserCredential credential) {

        UserCredentialEntity entity = mapper.toEntity(credential);

        persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        delete("id", id);
    }
}
package com.jusconnect.users.infrastructure.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import com.jusconnect.users.domain.model.User;
import com.jusconnect.users.domain.repository.UserRepository;

import com.jusconnect.users.infrastructure.persistence.entity.UserEntity;
import com.jusconnect.users.infrastructure.persistence.mapper.UserPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheUserRepository implements UserRepository, PanacheRepository<UserEntity> {

    private final UserPersistenceMapper mapper;

    public PanacheUserRepository(UserPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Optional<User> findById(UUID id) {

        return find("id", id)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return find("email", email)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    @Transactional
    public User save(User user) {

        UserEntity entity = mapper.toEntity(user);

        persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        delete("id", id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
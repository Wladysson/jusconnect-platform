package com.jusconnect.users.infrastructure.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.users.domain.model.LawyerProfile;
import com.jusconnect.users.domain.repository.LawyerRepository;

import com.jusconnect.users.infrastructure.persistence.entity.LawyerProfileEntity;
import com.jusconnect.users.infrastructure.persistence.mapper.UserPersistenceMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheLawyerRepository implements LawyerRepository, PanacheRepository<LawyerProfileEntity> {

    private final UserPersistenceMapper mapper;

    public PanacheLawyerRepository(UserPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Optional<LawyerProfile> findByUserId(UUID userId) {

        return find("userId", userId)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public List<LawyerProfile> findBySpecialty(String specialty) {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public LawyerProfile save(LawyerProfile profile) {

        LawyerProfileEntity entity = mapper.toEntity(profile);

        persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<LawyerProfile> findById(UUID id) {
        return Optional.empty();
    }
}
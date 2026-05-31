package com.jusconnect.lawyers.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import com.jusconnect.lawyers.domain.model.LawyerAvailability;
import com.jusconnect.lawyers.domain.repository.AvailabilityRepository;

import com.jusconnect.lawyers.infrastructure.persistence.entity.LawyerAvailabilityEntity;
import com.jusconnect.lawyers.infrastructure.persistence.mapper.LawyerPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheAvailabilityRepository
        implements AvailabilityRepository,
        PanacheRepositoryBase<LawyerAvailabilityEntity, UUID> {

    @Inject
    LawyerPersistenceMapper mapper;

    @Override
    public void save(LawyerAvailability availability) {

        LawyerAvailabilityEntity entity =
                mapper.toEntity(availability);

        persistOrUpdate(entity);
    }

    @Override
    public Optional<LawyerAvailability> findById(UUID id) {

        return find("id", id)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

}
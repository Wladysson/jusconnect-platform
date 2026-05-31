package com.jusconnect.lawyers.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.lawyers.domain.model.LawyerAvailability;
import com.jusconnect.lawyers.domain.repository.AvailabilityRepository;

import com.jusconnect.lawyers.infrastructure.persistence.mapper.LawyerPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheAvailabilityRepository
        implements AvailabilityRepository {

    @Inject
    AvailabilityPanacheRepository panache;

    @Inject
    LawyerPersistenceMapper mapper;

    @Override
    public void save(LawyerAvailability availability) {

        panache.persistOrUpdate(
                mapper.toEntity(availability)
        );
    }

    @Override
    public Optional<LawyerAvailability> findById(UUID id) {

        return panache.find("id", id)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {

        panache.delete("id", id);
    }
}
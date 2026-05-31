package com.jusconnect.lawyers.infrastructure.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;

import com.jusconnect.lawyers.infrastructure.persistence.entity.LawyerEntity;
import com.jusconnect.lawyers.infrastructure.persistence.mapper.LawyerPersistenceMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheLawyerRepository
        implements LawyerRepository,
        PanacheRepository<LawyerEntity> {

    @Inject
    LawyerPersistenceMapper mapper;

    @Override
    public Lawyer save(
            Lawyer lawyer
    ) {

        LawyerEntity entity =
                mapper.toEntity(lawyer);

        persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Lawyer> findById(
            UUID id
    ) {

        return find(
                "id",
                id
        )
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Lawyer> findByUserId(
            UUID userId
    ) {

        return find(
                "userId",
                userId
        )
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public List<Lawyer> findAll() {

        return (PanacheQuery<LawyerEntity>) listAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Lawyer> search(
            String specialty,
            String state
    ) {

        String query =
                "(:specialty is null or specialty = :specialty) " +
                        "and (:state is null or stateBar = :state)";

        return find(
                query,
                io.quarkus.panache.common.Parameters
                        .with("specialty", specialty)
                        .and("state", state)
        )
                .list()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(
            UUID id
    ) {

        delete(
                "id",
                id
        );
    }

    @Override
    public boolean existsByUserId(UUID userId) {
        return false;
    }

    @Override
    public List<Lawyer> search(String specialty, String stateBar, String city, Boolean online) {
        return List.of();
    }
}
package com.jusconnect.lawyers.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.panache.common.Parameters;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;

import com.jusconnect.lawyers.infrastructure.persistence.mapper.LawyerPersistenceMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheLawyerRepository
        implements LawyerRepository {

    @Inject
    LawyerPersistenceMapper mapper;

    @Inject
    LawyerPanacheRepository panache;

    @Override
    public Lawyer save(
            Lawyer lawyer
    ) {

        var entity =
                mapper.toEntity(lawyer);

        panache.persistOrUpdate(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Lawyer> findById(
            UUID id
    ) {

        return panache.find(
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

        return panache.find(
                        "userId",
                        userId
                )
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public List<Lawyer> findAll() {

        return panache.listAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Lawyer> search(
            String specialty,
            String stateBar
    ) {

        return panache.find(
                        "(:specialty is null or specialty = :specialty) " +
                                "and (:stateBar is null or stateBar = :stateBar)",
                        Parameters.with(
                                "specialty",
                                specialty
                        ).and(
                                "stateBar",
                                stateBar
                        )
                )
                .list()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Lawyer> search(
            String specialty,
            String stateBar,
            String city,
            Boolean online
    ) {

        return panache.listAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByUserId(
            UUID userId
    ) {

        return panache.count(
                "userId",
                userId
        ) > 0;
    }

    @Override
    public void deleteById(
            UUID id
    ) {

        panache.delete(
                "id",
                id
        );
    }
}
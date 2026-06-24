package com.jusconnect.triage.infrastructure.persistence.repository;

import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.domain.repository.TriageRepository;
import com.jusconnect.triage.infrastructure.persistence.entity.TriageEntity;
import com.jusconnect.triage.infrastructure.persistence.mapper.TriagePersistenceMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class PanacheTriageRepository
        implements TriageRepository,
        PanacheRepository<TriageEntity> {

    @Override
    public Triage save(
            Triage triage
    ) {

        TriageEntity entity =
                TriagePersistenceMapper.toEntity(
                        triage
                );

        persist(entity);

        return TriagePersistenceMapper.toDomain(
                entity
        );
    }

    @Override
    public List<Triage> findByStatus(
            String status
    ) {

        return find(
                "status",
                status
        )
                .list()
                .stream()
                .map(
                        TriagePersistenceMapper::toDomain
                )
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public void update(
            Triage triage
    ) {

        TriageEntity entity =
                TriagePersistenceMapper.toEntity(
                        triage
                );

        getEntityManager().merge(
                entity
        );
    }

    @Override
    public void delete(
            UUID id
    ) {

        delete(
                "id",
                id
        );
    }

    @Override
    public Optional<Triage> findById(
            UUID id
    ) {

        TriageEntity entity =
                find(
                        "id",
                        id
                ).firstResult();

        return Optional.ofNullable(
                TriagePersistenceMapper.toDomain(
                        entity
                )
        );
    }

    @Override
    public List<Triage> findAllTriages() {

        return listAll()
                .stream()
                .map(
                        TriagePersistenceMapper::toDomain
                )
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public List<Triage> findByIntakeId(
            UUID intakeId
    ) {

        return find(
                "intakeId",
                intakeId
        )
                .list()
                .stream()
                .map(
                        TriagePersistenceMapper::toDomain
                )
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public List<Triage> search(
            String status,
            String legalArea,
            String priority
    ) {

        return listAll()
                .stream()
                .map(
                        TriagePersistenceMapper::toDomain
                )
                .collect(
                        Collectors.toList()
                );
    }
}
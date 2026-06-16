package com.jusconnect.intake.infrastructure.persistence.repository;

import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.repository.IntakeRepository;
import com.jusconnect.intake.infrastructure.persistence.entity.IntakeEntity;
import com.jusconnect.intake.infrastructure.persistence.mapper.IntakePersistenceMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class PanacheIntakeRepository
        implements IntakeRepository,
        PanacheRepository<IntakeEntity> {

    @Override
    public Intake save(
            Intake intake
    ) {

        IntakeEntity entity =
                IntakePersistenceMapper.toEntity(
                        intake
                );

        persist(entity);

        return IntakePersistenceMapper.toDomain(
                entity
        );
    }

    @Override
    public void update(Intake intake) {

    }

    @Override
    public Optional<Intake> findById(
            UUID id
    ) {

        IntakeEntity entity = find(
                "id",
                id
        ).firstResult();

        return Optional.ofNullable(
                IntakePersistenceMapper.toDomain(
                        entity
                )
        );
    }

    @Override
    public List<Intake> findAllIntakes() {

        return listAll()
                .stream()
                .map(
                        IntakePersistenceMapper::toDomain
                )
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public List<Intake> findByLeadId(UUID leadId) {
        return List.of();
    }

    @Override
    public List<Intake> search(String status, String type, Object createdBy) {
        return List.of();
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
}
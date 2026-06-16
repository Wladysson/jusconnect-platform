package com.jusconnect.intake.infrastructure.persistence.repository;

import com.jusconnect.intake.domain.model.IntakeAnswer;
import com.jusconnect.intake.domain.repository.IntakeAnswerRepository;
import com.jusconnect.intake.infrastructure.persistence.entity.IntakeAnswerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheIntakeAnswerRepository
        implements IntakeAnswerRepository,
        PanacheRepository<IntakeAnswerEntity> {

    @Override
    public void save(
            IntakeAnswer answer
    ) {

        IntakeAnswerEntity entity =
                new IntakeAnswerEntity();

        entity.setId(
                answer.getId()
        );

        entity.setIntakeId(
                answer.getIntakeId()
        );

        entity.setStepId(
                answer.getStepId()
        );

        entity.setAnswer(
                answer.getAnswer()
        );

        entity.setCreatedAt(
                answer.getCreatedAt()
        );

        persist(entity);
    }

    @Override
    public void update(IntakeAnswer answer) {

    }

    @Override
    public Optional<IntakeAnswer> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<IntakeAnswer> findByStepId(UUID stepId) {
        return List.of();
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<IntakeAnswerEntity> findByIntakeId(
            UUID intakeId
    ) {

        return find(
                "intakeId",
                intakeId
        ).list();
    }
}
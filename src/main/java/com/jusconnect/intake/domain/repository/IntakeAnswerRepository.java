package com.jusconnect.intake.domain.repository;

import com.jusconnect.intake.domain.model.IntakeAnswer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IntakeAnswerRepository {

    void save(IntakeAnswer answer);

    void update(IntakeAnswer answer);

    Optional<IntakeAnswer> findById(UUID id);

    List<IntakeAnswer> findByStepId(UUID stepId);

    void delete(UUID id);

}
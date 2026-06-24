package com.jusconnect.triage.domain.repository;

import com.jusconnect.triage.domain.model.Triage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TriageRepository {

    Triage save(
            Triage triage
    );

    void update(
            Triage triage
    );

    void delete(
            UUID id
    );

    Optional<Triage> findById(
            UUID id
    );

    List<Triage> findAllTriages();

    List<Triage> findByIntakeId(
            UUID intakeId
    );

    List<Triage> findByStatus(
            String status
    );

    List<Triage> search(
            String status,
            String legalArea,
            String priority
    );
}
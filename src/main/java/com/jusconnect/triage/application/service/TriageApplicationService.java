package com.jusconnect.triage.application.service;

import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.domain.repository.TriageRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TriageApplicationService {

    private final TriageRepository triageRepository;

    public TriageApplicationService(
            TriageRepository triageRepository
    ) {
        this.triageRepository = triageRepository;
    }

    public Triage save(
            Triage triage
    ) {

        return triageRepository.save(
                triage
        );
    }

    public void update(
            Triage triage
    ) {

        triageRepository.update(
                triage
        );
    }

    public void delete(
            UUID id
    ) {

        triageRepository.delete(
                id
        );
    }

    public Optional<Triage> findById(
            UUID id
    ) {

        return triageRepository.findById(
                id
        );
    }

    public List<Triage> findAll() {

        return triageRepository.findAllTriages();
    }

    public List<Triage> findByIntakeId(
            UUID intakeId
    ) {

        return triageRepository.findByIntakeId(
                intakeId
        );
    }

    public List<Triage> search(
            String status,
            String legalArea,
            String priority
    ) {

        return triageRepository.search(
                status,
                legalArea,
                priority
        );
    }
}
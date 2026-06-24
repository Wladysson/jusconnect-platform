package com.jusconnect.triage.application.usecase;

import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.domain.repository.TriageRepository;

import java.util.UUID;

public class GetTriageByIdUseCase {

    private final TriageRepository triageRepository;

    public GetTriageByIdUseCase(
            TriageRepository triageRepository
    ) {
        this.triageRepository = triageRepository;
    }

    public Triage execute(
            UUID id
    ) {

        return triageRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Triagem não encontrada"
                        )
                );
    }
}
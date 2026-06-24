package com.jusconnect.triage.application.usecase;

import com.jusconnect.triage.domain.enums.TriageStatus;
import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.domain.repository.TriageRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompleteTriageUseCase {

    private final TriageRepository triageRepository;

    public CompleteTriageUseCase(
            TriageRepository triageRepository
    ) {
        this.triageRepository = triageRepository;
    }

    public Triage execute(
            UUID triageId
    ) {

        Triage triage =
                triageRepository
                        .findById(
                                triageId
                        )
                        .orElseThrow(
                                () -> new IllegalArgumentException(
                                        "Triagem não encontrada"
                                )
                        );

        if (
                TriageStatus.COMPLETED.equals(
                        triage.getStatus()
                )
        ) {
            return triage;
        }

        triage.setStatus(
                TriageStatus.COMPLETED
        );

        triage.setUpdatedAt(
                LocalDateTime.now()
        );

        triageRepository.update(
                triage
        );

        return triage;
    }
}
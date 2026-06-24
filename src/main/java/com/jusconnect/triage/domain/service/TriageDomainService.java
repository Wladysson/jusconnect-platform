package com.jusconnect.triage.domain.service;

import com.jusconnect.triage.domain.enums.TriageStatus;
import com.jusconnect.triage.domain.model.Triage;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TriageDomainService {

    public Triage create(
            UUID intakeId
    ) {

        Triage triage = new Triage();

        triage.setId(
                UUID.randomUUID()
        );

        triage.setIntakeId(
                intakeId
        );

        triage.setStatus(
                TriageStatus.PENDING
        );

        triage.setCreatedAt(
                LocalDateTime.now()
        );

        triage.setUpdatedAt(
                LocalDateTime.now()
        );

        return triage;
    }

    public void validate(
            Triage triage
    ) {

        if (triage == null) {
            throw new IllegalArgumentException(
                    "Triagem inválida"
            );
        }

        if (triage.getIntakeId() == null) {
            throw new IllegalArgumentException(
                    "Intake obrigatório"
            );
        }
    }

    public void start(
            Triage triage
    ) {

        validate(triage);

        triage.setStatus(
                TriageStatus.IN_PROGRESS
        );

        triage.setUpdatedAt(
                LocalDateTime.now()
        );
    }

    public void complete(
            Triage triage
    ) {

        validate(triage);

        triage.setStatus(
                TriageStatus.COMPLETED
        );

        triage.setUpdatedAt(
                LocalDateTime.now()
        );
    }

    public void assign(
            Triage triage
    ) {

        validate(triage);

        triage.setStatus(
                TriageStatus.ASSIGNED
        );

        triage.setUpdatedAt(
                LocalDateTime.now()
        );
    }

    public void cancel(
            Triage triage
    ) {

        validate(triage);

        triage.setStatus(
                TriageStatus.CANCELLED
        );

        triage.setUpdatedAt(
                LocalDateTime.now()
        );
    }
}
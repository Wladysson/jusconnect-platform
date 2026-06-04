package com.jusconnect.intake.domain.service;

import com.jusconnect.intake.domain.enums.IntakeStatus;
import com.jusconnect.intake.domain.model.Intake;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IntakeDomainService {

    public void start(Intake intake) {

        if (intake.getStatus() == null) {
            intake.setStatus(
                    IntakeStatus.IN_PROGRESS.name()
            );
        }
    }

    public void complete(Intake intake) {

        intake.setStatus(
                IntakeStatus.COMPLETED.name()
        );
    }

    public boolean isCompleted(Intake intake) {

        return IntakeStatus.COMPLETED.name()
                .equals(
                        intake.getStatus()
                );
    }

    public boolean isPending(Intake intake) {

        return IntakeStatus.PENDING.name()
                .equals(
                        intake.getStatus()
                );
    }
}
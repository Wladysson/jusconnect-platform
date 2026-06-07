package com.jusconnect.intake.application.usecase;

import com.jusconnect.intake.application.dto.request.UpdateIntakeRequest;
import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class UpdateIntakeUseCase {

    @Inject
    IntakeRepository intakeRepository;

    public Intake execute(
            UUID intakeId,
            UpdateIntakeRequest request
    ) {

        Intake intake = intakeRepository.findById(
                intakeId
        );

        if (intake == null) {
            throw new IllegalArgumentException(
                    "Intake não encontrado"
            );
        }

        intake.setType(
                request.getType()
        );

        intake.setStatus(
                request.getStatus()
        );

        return intakeRepository.save(
                intake
        );
    }
}
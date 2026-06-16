package com.jusconnect.intake.application.usecase;

import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.model.IntakeStep;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GetIntakeStepsUseCase {

    @Inject
    IntakeRepository intakeRepository;

    public GetIntakeStepsUseCase(IntakeRepository intakeRepository) {
    }

    public List<IntakeStep> execute(
            UUID intakeId
    ) {

        Intake intake = intakeRepository.findById(
                intakeId
        ).orElseThrow(
                () -> new IllegalArgumentException(
                        "Intake não encontrado"
                )
        );

        if (intake == null) {
            throw new IllegalArgumentException(
                    "Intake não encontrado"
            );
        }

        if (intake.getSteps() == null) {
            return Collections.emptyList();
        }

        return intake.getSteps();
    }
}
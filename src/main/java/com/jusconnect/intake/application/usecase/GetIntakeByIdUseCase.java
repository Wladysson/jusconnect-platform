package com.jusconnect.intake.application.usecase;

import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class GetIntakeByIdUseCase {

    @Inject
    IntakeRepository intakeRepository;

    public GetIntakeByIdUseCase(IntakeRepository intakeRepository) {
    }

    public Intake execute(
            UUID intakeId
    ) {

        return intakeRepository.findById(
                intakeId
        ).orElseThrow(
                () -> new IllegalArgumentException(
                        "Intake não encontrado"
                )
        );
    }
}
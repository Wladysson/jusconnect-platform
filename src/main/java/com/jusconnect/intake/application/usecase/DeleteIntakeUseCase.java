package com.jusconnect.intake.application.usecase;

import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class DeleteIntakeUseCase {

    @Inject
    IntakeRepository intakeRepository;

    @Transactional
    public void execute(
            UUID intakeId
    ) {

        Intake intake = intakeRepository.findById(
                intakeId
        );

        if (intake == null) {
            throw new IllegalArgumentException(
                    "Intake não encontrado"
            );
        }

        intakeRepository.delete(
                intakeId
        );
    }
}
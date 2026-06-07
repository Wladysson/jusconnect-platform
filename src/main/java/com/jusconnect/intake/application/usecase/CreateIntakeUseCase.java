package com.jusconnect.intake.application.usecase;

import com.jusconnect.intake.application.dto.request.CreateIntakeRequest;
import com.jusconnect.intake.domain.enums.IntakeStatus;
import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class CreateIntakeUseCase {

    @Inject
    IntakeRepository intakeRepository;

    public Intake execute(
            CreateIntakeRequest request
    ) {

        Intake intake = new Intake();

        intake.setId(
                UUID.randomUUID()
        );

        intake.setLeadId(
                request.getLeadId()
        );

        intake.setType(
                request.getType()
        );

        intake.setStatus(
                IntakeStatus.IN_PROGRESS
        );

        intake.setCreatedAt(
                LocalDateTime.now()
        );

        return intakeRepository.save(
                intake
        );
    }
}
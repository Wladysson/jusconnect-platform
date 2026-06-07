package com.jusconnect.intake.application.service;

import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class IntakeApplicationService {

    @Inject
    IntakeRepository intakeRepository;

    public Intake create(
            Intake intake
    ) {
        return intakeRepository.save(intake);
    }

    public Intake update(
            Intake intake
    ) {
        return intakeRepository.save(intake);
    }

    public Optional<Intake> findById(
            UUID intakeId
    ) {
        return intakeRepository.findById(intakeId);
    }

    public List<Intake> findAll() {
        return intakeRepository.findAll();
    }

    public void delete(
            UUID intakeId
    ) {
        intakeRepository.delete(intakeId);
    }
}
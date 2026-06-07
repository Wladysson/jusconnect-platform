package com.jusconnect.intake.application.usecase;

import com.jusconnect.intake.application.dto.request.SearchIntakeRequest;
import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class SearchIntakesUseCase {

    @Inject
    IntakeRepository intakeRepository;

    public List<Intake> execute(
            SearchIntakeRequest request
    ) {

        return intakeRepository.search(
                request.getStatus(),
                request.getType(),
                request.getCreatedBy()
        );
    }
}
package com.jusconnect.intake.infrastructure.config;

import com.jusconnect.intake.application.usecase.CreateIntakeUseCase;
import com.jusconnect.intake.application.usecase.DeleteIntakeUseCase;
import com.jusconnect.intake.application.usecase.GetIntakeByIdUseCase;
import com.jusconnect.intake.application.usecase.GetIntakeStepsUseCase;
import com.jusconnect.intake.application.usecase.SearchIntakesUseCase;
import com.jusconnect.intake.application.usecase.SubmitAnswerUseCase;
import com.jusconnect.intake.application.usecase.UpdateIntakeUseCase;
import com.jusconnect.intake.application.usecase.UploadDocumentUseCase;
import com.jusconnect.intake.domain.repository.IntakeAnswerRepository;
import com.jusconnect.intake.domain.repository.IntakeRepository;
import com.jusconnect.intake.domain.service.IntakeDomainService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class IntakeConfig {

    @Produces
    public CreateIntakeUseCase createIntakeUseCase(
            IntakeRepository intakeRepository,
            IntakeDomainService intakeDomainService
    ) {
        return new CreateIntakeUseCase(
                intakeRepository,
                intakeDomainService
        );
    }

    @Produces
    public UpdateIntakeUseCase updateIntakeUseCase(
            IntakeRepository intakeRepository
    ) {
        return new UpdateIntakeUseCase(
                intakeRepository
        );
    }

    @Produces
    public GetIntakeByIdUseCase getIntakeByIdUseCase(
            IntakeRepository intakeRepository
    ) {
        return new GetIntakeByIdUseCase(
                intakeRepository
        );
    }

    @Produces
    public SearchIntakesUseCase searchIntakesUseCase(
            IntakeRepository intakeRepository
    ) {
        return new SearchIntakesUseCase(
                intakeRepository
        );
    }

    @Produces
    public SubmitAnswerUseCase submitAnswerUseCase(
            IntakeRepository intakeRepository,
            IntakeAnswerRepository intakeAnswerRepository
    ) {
        return new SubmitAnswerUseCase(
                intakeRepository,
                intakeAnswerRepository
        );
    }

    @Produces
    public UploadDocumentUseCase uploadDocumentUseCase(
            IntakeRepository intakeRepository
    ) {
        return new UploadDocumentUseCase(
                intakeRepository
        );
    }

    @Produces
    public GetIntakeStepsUseCase getIntakeStepsUseCase(
            IntakeRepository intakeRepository
    ) {
        return new GetIntakeStepsUseCase(
                intakeRepository
        );
    }

    @Produces
    public DeleteIntakeUseCase deleteIntakeUseCase(
            IntakeRepository intakeRepository
    ) {
        return new DeleteIntakeUseCase(
                intakeRepository
        );
    }
}
package com.jusconnect.triage.infrastructure.config;

import com.jusconnect.triage.application.usecase.CompleteTriageUseCase;
import com.jusconnect.triage.application.usecase.CreateTriageUseCase;
import com.jusconnect.triage.application.usecase.GetTriageByIdUseCase;
import com.jusconnect.triage.application.usecase.RecalculateTriageUseCase;
import com.jusconnect.triage.application.usecase.SearchTriagesUseCase;
import com.jusconnect.triage.application.usecase.SuggestLawyersUseCase;
import com.jusconnect.triage.domain.repository.TriageRepository;
import com.jusconnect.triage.domain.service.LawyerRecommendationService;
import com.jusconnect.triage.domain.service.TriageDomainService;
import com.jusconnect.triage.domain.service.TriageScoreCalculator;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class TriageConfig {

    @Produces
    public CreateTriageUseCase createTriageUseCase(
            TriageRepository repository,
            TriageDomainService domainService
    ) {
        return new CreateTriageUseCase(
                repository,
                domainService
        );
    }

    @Produces
    public GetTriageByIdUseCase getTriageByIdUseCase(
            TriageRepository repository
    ) {
        return new GetTriageByIdUseCase(
                repository
        );
    }

    @Produces
    public SearchTriagesUseCase searchTriagesUseCase(
            TriageRepository repository
    ) {
        return new SearchTriagesUseCase(
                repository
        );
    }

    @Produces
    public RecalculateTriageUseCase recalculateTriageUseCase(
            TriageRepository repository,
            TriageScoreCalculator calculator
    ) {
        return new RecalculateTriageUseCase(
                repository,
                calculator
        );
    }

    @Produces
    public SuggestLawyersUseCase suggestLawyersUseCase(
            TriageRepository repository,
            LawyerRecommendationService recommendationService
    ) {
        return new SuggestLawyersUseCase(
                repository,
                recommendationService
        );
    }

    @Produces
    public CompleteTriageUseCase completeTriageUseCase(
            TriageRepository repository
    ) {
        return new CompleteTriageUseCase(
                repository
        );
    }
}
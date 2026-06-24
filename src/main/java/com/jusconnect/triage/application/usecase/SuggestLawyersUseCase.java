package com.jusconnect.triage.application.usecase;

import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.domain.repository.TriageRepository;
import com.jusconnect.triage.domain.service.LawyerRecommendationService;

import java.util.List;
import java.util.UUID;

public class SuggestLawyersUseCase {

    private final TriageRepository triageRepository;

    private final LawyerRecommendationService lawyerRecommendationService;

    public SuggestLawyersUseCase(
            TriageRepository triageRepository,
            LawyerRecommendationService lawyerRecommendationService
    ) {

        this.triageRepository = triageRepository;
        this.lawyerRecommendationService =
                lawyerRecommendationService;
    }

    public List<?> execute(
            UUID triageId
    ) {

        Triage triage =
                triageRepository
                        .findById(
                                triageId
                        )
                        .orElseThrow(
                                () -> new IllegalArgumentException(
                                        "Triagem não encontrada"
                                )
                        );

        return lawyerRecommendationService
                .recommend(
                        triage
                );
    }
}
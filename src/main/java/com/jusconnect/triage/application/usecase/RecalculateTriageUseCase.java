package com.jusconnect.triage.application.usecase;

import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.domain.model.TriageClassification;
import com.jusconnect.triage.domain.model.TriageScore;
import com.jusconnect.triage.domain.repository.TriageRepository;
import com.jusconnect.triage.domain.service.TriageScoreCalculator;

import java.util.UUID;

public class RecalculateTriageUseCase {

    private final TriageRepository triageRepository;

    private final TriageScoreCalculator triageScoreCalculator;

    public RecalculateTriageUseCase(
            TriageRepository triageRepository,
            TriageScoreCalculator triageScoreCalculator
    ) {

        this.triageRepository = triageRepository;
        this.triageScoreCalculator = triageScoreCalculator;
    }

    public Triage execute(
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

        TriageScore score =
                triageScoreCalculator.calculateScore(
                        triage
                );

        TriageClassification classification =
                triageScoreCalculator.classify(
                        triage
                );

        triage.setFinalScore(
                score.getFinalScore()
        );

        triage.setPriorityLevel(
                classification.getPriorityLevel()
        );

        triageRepository.update(
                triage
        );

        return triage;
    }
}
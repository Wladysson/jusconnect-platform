package com.jusconnect.triage.domain.service;

import com.jusconnect.triage.domain.model.LawyerSuggestion;
import com.jusconnect.triage.domain.model.Triage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LawyerRecommendationService {

    public List<LawyerSuggestion> recommend(
            Triage triage
    ) {

        List<LawyerSuggestion> suggestions =
                new ArrayList<>();

        LawyerSuggestion suggestion =
                new LawyerSuggestion();

        suggestion.setId(
                UUID.randomUUID()
        );

        suggestion.setTriageId(
                triage.getId()
        );

        suggestion.setLawyerId(
                UUID.randomUUID()
        );

        suggestion.setCompatibilityScore(
                calculateCompatibility(
                        triage
                )
        );

        suggestion.setReason(
                buildReason(
                        triage
                )
        );

        suggestion.setRecommendedAt(
                LocalDateTime.now()
        );

        suggestions.add(
                suggestion
        );

        return suggestions;
    }

    private Double calculateCompatibility(
            Triage triage
    ) {

        if (triage.getPriorityLevel() == null) {
            return 50.0;
        }

        return switch (
                triage.getPriorityLevel()
                ) {

            case LOW -> 60.0;

            case MEDIUM -> 75.0;

            case HIGH -> 90.0;

            case CRITICAL -> 100.0;
        };
    }

    private String buildReason(
            Triage triage
    ) {

        String legalArea =
                triage.getLegalArea() == null
                        ? "GENERAL"
                        : triage.getLegalArea().name();

        return "Advogado recomendado para área "
                + legalArea;
    }
}
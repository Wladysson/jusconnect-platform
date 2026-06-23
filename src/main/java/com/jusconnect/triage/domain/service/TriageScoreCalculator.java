package com.jusconnect.triage.domain.service;

import com.jusconnect.triage.domain.enums.PriorityLevel;
import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.domain.model.TriageClassification;
import com.jusconnect.triage.domain.model.TriageScore;

public class TriageScoreCalculator {

    public TriageScore calculateScore(
            Triage triage
    ) {

        TriageScore score = new TriageScore();

        int urgencyScore =
                calculateUrgencyScore(
                        triage
                );

        int complexityScore =
                calculateComplexityScore(
                        triage
                );

        int businessScore =
                calculateBusinessScore(
                        triage
                );

        int finalScore =
                urgencyScore
                        + complexityScore
                        + businessScore;

        score.setUrgencyScore(
                urgencyScore
        );

        score.setComplexityScore(
                complexityScore
        );

        score.setBusinessScore(
                businessScore
        );

        score.setFinalScore(
                finalScore
        );

        return score;
    }

    public TriageClassification classify(
            Triage triage
    ) {

        TriageScore score =
                calculateScore(
                        triage
                );

        TriageClassification classification =
                new TriageClassification();

        classification.setLegalArea(
                triage.getLegalArea()
        );

        classification.setUrgencyLevel(
                triage.getUrgencyLevel()
        );

        classification.setFinalScore(
                score.getFinalScore()
        );

        classification.setPriorityLevel(
                determinePriority(
                        score.getFinalScore()
                )
        );

        return classification;
    }

    private int calculateUrgencyScore(
            Triage triage
    ) {

        if (triage.getUrgencyLevel() == null) {
            return 0;
        }

        return switch (
                triage.getUrgencyLevel()
                ) {

            case LOW -> 10;

            case MEDIUM -> 25;

            case HIGH -> 40;

            case EMERGENCY -> 60;
        };
    }

    private int calculateComplexityScore(
            Triage triage
    ) {

        if (triage.getNotes() == null) {
            return 10;
        }

        int size =
                triage.getNotes()
                        .length();

        if (size < 100) {
            return 10;
        }

        if (size < 500) {
            return 20;
        }

        return 30;
    }

    private int calculateBusinessScore(
            Triage triage
    ) {

        return 20;
    }

    private PriorityLevel determinePriority(
            Integer finalScore
    ) {

        if (finalScore >= 100) {
            return PriorityLevel.CRITICAL;
        }

        if (finalScore >= 70) {
            return PriorityLevel.HIGH;
        }

        if (finalScore >= 40) {
            return PriorityLevel.MEDIUM;
        }

        return PriorityLevel.LOW;
    }
}
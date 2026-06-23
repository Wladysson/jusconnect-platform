package com.jusconnect.triage.application.dto.response;

import com.jusconnect.triage.domain.enums.PriorityLevel;

public class TriageScoreResponse {

    private Integer urgencyScore;

    private Integer complexityScore;

    private Integer businessScore;

    private Integer finalScore;

    private PriorityLevel priorityLevel;

    public TriageScoreResponse() {
    }

    public Integer getUrgencyScore() {
        return urgencyScore;
    }

    public void setUrgencyScore(
            Integer urgencyScore
    ) {
        this.urgencyScore = urgencyScore;
    }

    public Integer getComplexityScore() {
        return complexityScore;
    }

    public void setComplexityScore(
            Integer complexityScore
    ) {
        this.complexityScore = complexityScore;
    }

    public Integer getBusinessScore() {
        return businessScore;
    }

    public void setBusinessScore(
            Integer businessScore
    ) {
        this.businessScore = businessScore;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(
            Integer finalScore
    ) {
        this.finalScore = finalScore;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(
            PriorityLevel priorityLevel
    ) {
        this.priorityLevel = priorityLevel;
    }
}
package com.jusconnect.triage.domain.model;

import java.util.UUID;

public class TriageScore {

    private UUID id;

    private UUID triageId;

    private Integer urgencyScore;

    private Integer complexityScore;

    private Integer businessScore;

    private Integer finalScore;

    public TriageScore() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTriageId() {
        return triageId;
    }

    public void setTriageId(UUID triageId) {
        this.triageId = triageId;
    }

    public Integer getUrgencyScore() {
        return urgencyScore;
    }

    public void setUrgencyScore(Integer urgencyScore) {
        this.urgencyScore = urgencyScore;
    }

    public Integer getComplexityScore() {
        return complexityScore;
    }

    public void setComplexityScore(Integer complexityScore) {
        this.complexityScore = complexityScore;
    }

    public Integer getBusinessScore() {
        return businessScore;
    }

    public void setBusinessScore(Integer businessScore) {
        this.businessScore = businessScore;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }
}
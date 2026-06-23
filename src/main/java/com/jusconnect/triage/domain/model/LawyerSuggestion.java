package com.jusconnect.triage.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class LawyerSuggestion {

    private UUID id;

    private UUID triageId;

    private UUID lawyerId;

    private Double compatibilityScore;

    private String reason;

    private LocalDateTime recommendedAt;

    public LawyerSuggestion() {
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

    public UUID getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(UUID lawyerId) {
        this.lawyerId = lawyerId;
    }

    public Double getCompatibilityScore() {
        return compatibilityScore;
    }

    public void setCompatibilityScore(Double compatibilityScore) {
        this.compatibilityScore = compatibilityScore;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getRecommendedAt() {
        return recommendedAt;
    }

    public void setRecommendedAt(LocalDateTime recommendedAt) {
        this.recommendedAt = recommendedAt;
    }
}
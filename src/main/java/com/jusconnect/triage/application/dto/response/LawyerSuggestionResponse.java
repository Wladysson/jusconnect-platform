package com.jusconnect.triage.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class LawyerSuggestionResponse {

    private UUID lawyerId;

    private String lawyerName;

    private Double compatibilityScore;

    private String reason;

    private LocalDateTime recommendedAt;

    public LawyerSuggestionResponse() {
    }

    public UUID getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(
            UUID lawyerId
    ) {
        this.lawyerId = lawyerId;
    }

    public String getLawyerName() {
        return lawyerName;
    }

    public void setLawyerName(
            String lawyerName
    ) {
        this.lawyerName = lawyerName;
    }

    public Double getCompatibilityScore() {
        return compatibilityScore;
    }

    public void setCompatibilityScore(
            Double compatibilityScore
    ) {
        this.compatibilityScore = compatibilityScore;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(
            String reason
    ) {
        this.reason = reason;
    }

    public LocalDateTime getRecommendedAt() {
        return recommendedAt;
    }

    public void setRecommendedAt(
            LocalDateTime recommendedAt
    ) {
        this.recommendedAt = recommendedAt;
    }
}
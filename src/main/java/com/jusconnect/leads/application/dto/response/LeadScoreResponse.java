package com.jusconnect.leads.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class LeadScoreResponse {

    private UUID id;
    private Integer score;
    private String reason;
    private LocalDateTime calculatedAt;

    public LeadScoreResponse(
            UUID id,
            Integer score,
            String reason,
            LocalDateTime calculatedAt
    ) {
        this.id = id;
        this.score = score;
        this.reason = reason;
        this.calculatedAt = calculatedAt;
    }

    public UUID getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }
}
package com.jusconnect.leads.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class LeadHistoryResponse {

    private UUID id;
    private String action;
    private String description;
    private LocalDateTime createdAt;

    public LeadHistoryResponse(
            UUID id,
            String action,
            String description,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.action = action;
        this.description = description;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
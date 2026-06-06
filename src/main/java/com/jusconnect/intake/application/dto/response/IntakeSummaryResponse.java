package com.jusconnect.intake.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class IntakeSummaryResponse {

    private UUID id;
    private UUID leadId;
    private String status;
    private String type;
    private LocalDateTime createdAt;

    public IntakeSummaryResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
        this.id = id;
    }

    public UUID getLeadId() {
        return leadId;
    }

    public void setLeadId(
            UUID leadId
    ) {
        this.leadId = leadId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(
            String type
    ) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(
            LocalDateTime createdAt
    ) {
        this.createdAt = createdAt;
    }
}
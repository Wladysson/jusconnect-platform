package com.jusconnect.leads.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class LeadAssignmentResponse {

    private UUID id;
    private UUID leadId;
    private UUID lawyerId;
    private LocalDateTime assignedAt;

    public LeadAssignmentResponse(
            UUID id,
            UUID leadId,
            UUID lawyerId,
            LocalDateTime assignedAt
    ) {
        this.id = id;
        this.leadId = leadId;
        this.lawyerId = lawyerId;
        this.assignedAt = assignedAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getLeadId() {
        return leadId;
    }

    public UUID getLawyerId() {
        return lawyerId;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }
}
package com.jusconnect.intake.application.dto.request;

import java.util.UUID;

public class SearchIntakeRequest {

    private UUID leadId;
    private String status;
    private String type;

    public SearchIntakeRequest() {
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
}
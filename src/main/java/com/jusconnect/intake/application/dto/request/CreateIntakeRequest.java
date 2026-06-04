package com.jusconnect.intake.application.dto.request;

import java.util.UUID;

public class CreateIntakeRequest {

    private UUID leadId;
    private String type;

    public CreateIntakeRequest() {
    }

    public UUID getLeadId() {
        return leadId;
    }

    public void setLeadId(
            UUID leadId
    ) {
        this.leadId = leadId;
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
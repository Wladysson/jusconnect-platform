package com.jusconnect.leads.application.dto.response;

import java.util.UUID;

public class LeadSummaryResponse {

    private UUID id;
    private String name;
    private String status;

    public LeadSummaryResponse(
            UUID id,
            String name,
            String status
    ) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
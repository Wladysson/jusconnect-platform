package com.jusconnect.triage.application.dto.request;

import java.util.UUID;

public class RecalculateTriageRequest {

    private UUID triageId;

    public RecalculateTriageRequest() {
    }

    public UUID getTriageId() {
        return triageId;
    }

    public void setTriageId(UUID triageId) {
        this.triageId = triageId;
    }
}
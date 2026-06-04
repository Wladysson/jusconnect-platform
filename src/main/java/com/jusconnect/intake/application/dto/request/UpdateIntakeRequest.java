package com.jusconnect.intake.application.dto.request;

import java.util.UUID;

public class UpdateIntakeRequest {

    private UUID intakeId;
    private String status;
    private String type;

    public UpdateIntakeRequest() {
    }

    public UUID getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(
            UUID intakeId
    ) {
        this.intakeId = intakeId;
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
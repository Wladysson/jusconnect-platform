package com.jusconnect.intake.application.dto.response;

import java.util.UUID;

public class IntakeStepResponse {

    private UUID id;
    private String title;
    private String description;
    private String status;
    private Integer order;

    public IntakeStepResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(
            String title
    ) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            String description
    ) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(
            Integer order
    ) {
        this.order = order;
    }
}
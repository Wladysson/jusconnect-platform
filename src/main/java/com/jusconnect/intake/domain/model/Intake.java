package com.jusconnect.intake.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Intake {

    private UUID id;
    private UUID leadId;
    private String status;
    private LocalDateTime createdAt;

    private List<IntakeStep> steps = new ArrayList<>();
    private List<IntakeDocument> documents = new ArrayList<>();

    public Intake() {
    }

    public Intake(
            UUID id,
            UUID leadId,
            String status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.leadId = leadId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getLeadId() {
        return leadId;
    }

    public void setLeadId(UUID leadId) {
        this.leadId = leadId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<IntakeStep> getSteps() {
        return steps;
    }

    public void setSteps(List<IntakeStep> steps) {
        this.steps = steps;
    }

    public List<IntakeDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<IntakeDocument> documents) {
        this.documents = documents;
    }
}
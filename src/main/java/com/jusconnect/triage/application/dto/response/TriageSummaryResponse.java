package com.jusconnect.triage.application.dto.response;

import com.jusconnect.triage.domain.enums.LegalArea;
import com.jusconnect.triage.domain.enums.PriorityLevel;
import com.jusconnect.triage.domain.enums.TriageStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class TriageSummaryResponse {

    private UUID id;

    private UUID intakeId;

    private TriageStatus status;

    private LegalArea legalArea;

    private PriorityLevel priorityLevel;

    private Integer finalScore;

    private LocalDateTime createdAt;

    public TriageSummaryResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(UUID intakeId) {
        this.intakeId = intakeId;
    }

    public TriageStatus getStatus() {
        return status;
    }

    public void setStatus(TriageStatus status) {
        this.status = status;
    }

    public LegalArea getLegalArea() {
        return legalArea;
    }

    public void setLegalArea(LegalArea legalArea) {
        this.legalArea = legalArea;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
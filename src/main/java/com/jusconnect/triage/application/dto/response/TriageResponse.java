package com.jusconnect.triage.application.dto.response;

import com.jusconnect.triage.domain.enums.LegalArea;
import com.jusconnect.triage.domain.enums.PriorityLevel;
import com.jusconnect.triage.domain.enums.TriageStatus;
import com.jusconnect.triage.domain.enums.UrgencyLevel;

import java.time.LocalDateTime;
import java.util.UUID;

public class TriageResponse {

    private UUID id;

    private UUID intakeId;

    private TriageStatus status;

    private LegalArea legalArea;

    private PriorityLevel priorityLevel;

    private UrgencyLevel urgencyLevel;

    private String notes;

    private Integer finalScore;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TriageResponse() {
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

    public UrgencyLevel getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(UrgencyLevel urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
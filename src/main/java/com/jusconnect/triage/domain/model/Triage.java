package com.jusconnect.triage.domain.model;

import com.jusconnect.triage.domain.enums.LegalArea;
import com.jusconnect.triage.domain.enums.PriorityLevel;
import com.jusconnect.triage.domain.enums.TriageStatus;
import com.jusconnect.triage.domain.enums.UrgencyLevel;

import java.time.LocalDateTime;
import java.util.UUID;

public class Triage {

    private UUID id;

    private UUID intakeId;

    private LegalArea legalArea;

    private PriorityLevel priorityLevel;

    private UrgencyLevel urgencyLevel;

    private Integer score;

    private String notes;

    private TriageStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Triage() {
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TriageStatus getStatus() {
        return status;
    }

    public void setStatus(TriageStatus status) {
        this.status = status;
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

    public Integer getFinalScore() {
        return 0;
    }
}
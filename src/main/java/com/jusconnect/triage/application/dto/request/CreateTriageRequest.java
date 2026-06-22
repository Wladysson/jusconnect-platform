package com.jusconnect.triage.application.dto.request;

import com.jusconnect.triage.domain.enums.LegalArea;
import com.jusconnect.triage.domain.enums.UrgencyLevel;

import java.util.UUID;

public class CreateTriageRequest {

    private UUID intakeId;

    private LegalArea legalArea;

    private UrgencyLevel urgencyLevel;

    private String notes;

    public CreateTriageRequest() {
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
}
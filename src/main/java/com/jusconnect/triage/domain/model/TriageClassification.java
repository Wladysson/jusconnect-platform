package com.jusconnect.triage.domain.model;

import com.jusconnect.triage.domain.enums.LegalArea;
import com.jusconnect.triage.domain.enums.PriorityLevel;
import com.jusconnect.triage.domain.enums.UrgencyLevel;

public class TriageClassification {

    private LegalArea legalArea;

    private PriorityLevel priorityLevel;

    private UrgencyLevel urgencyLevel;

    private Integer finalScore;

    public TriageClassification() {
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

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }
}
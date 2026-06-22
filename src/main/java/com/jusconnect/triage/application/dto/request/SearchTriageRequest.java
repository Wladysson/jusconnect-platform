package com.jusconnect.triage.application.dto.request;

public class SearchTriageRequest {

    private String status;

    private String legalArea;

    private String priority;

    public SearchTriageRequest() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }

    public String getLegalArea() {
        return legalArea;
    }

    public void setLegalArea(
            String legalArea
    ) {
        this.legalArea = legalArea;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(
            String priority
    ) {
        this.priority = priority;
    }
}
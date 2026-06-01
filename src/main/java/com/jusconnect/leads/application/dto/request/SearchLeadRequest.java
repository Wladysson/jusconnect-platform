package com.jusconnect.leads.application.dto.request;

public class SearchLeadRequest {

    private String legalArea;
    private String status;
    private String priority;

    public SearchLeadRequest() {
    }

    public String getLegalArea() {
        return legalArea;
    }

    public void setLegalArea(String legalArea) {
        this.legalArea = legalArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
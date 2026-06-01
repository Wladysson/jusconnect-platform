package com.jusconnect.leads.application.dto.request;

import java.util.UUID;

public class AssignLeadRequest {

    private UUID lawyerId;

    public AssignLeadRequest() {
    }

    public UUID getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(UUID lawyerId) {
        this.lawyerId = lawyerId;
    }
}
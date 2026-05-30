package com.jusconnect.lawyers.application.dto.response;

import java.util.UUID;

public class LawyerSummaryResponse {

    private UUID id;
    private String oabNumber;
    private String level;
    private boolean verified;

    public LawyerSummaryResponse() {
    }

    public LawyerSummaryResponse(
            UUID id,
            String oabNumber,
            String level,
            boolean verified
    ) {
        this.id = id;
        this.oabNumber = oabNumber;
        this.level = level;
        this.verified = verified;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOabNumber() {
        return oabNumber;
    }

    public void setOabNumber(String oabNumber) {
        this.oabNumber = oabNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
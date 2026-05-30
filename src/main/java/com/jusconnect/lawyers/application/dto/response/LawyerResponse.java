package com.jusconnect.lawyers.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class LawyerResponse {

    private UUID id;
    private UUID userId;
    private String oabNumber;
    private String stateBar;
    private String bio;
    private String level;
    private boolean verified;
    private LocalDateTime createdAt;

    public LawyerResponse() {
    }

    public LawyerResponse(
            UUID id,
            UUID userId,
            String oabNumber,
            String stateBar,
            String bio,
            String level,
            boolean verified,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.userId = userId;
        this.oabNumber = oabNumber;
        this.stateBar = stateBar;
        this.bio = bio;
        this.level = level;
        this.verified = verified;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getOabNumber() {
        return oabNumber;
    }

    public void setOabNumber(String oabNumber) {
        this.oabNumber = oabNumber;
    }

    public String getStateBar() {
        return stateBar;
    }

    public void setStateBar(String stateBar) {
        this.stateBar = stateBar;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
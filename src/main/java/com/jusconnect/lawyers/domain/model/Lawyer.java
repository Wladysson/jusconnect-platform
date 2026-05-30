package com.jusconnect.lawyers.domain.model;

import com.jusconnect.lawyers.domain.enums.LawyerLevel;

import java.time.LocalDateTime;
import java.util.UUID;

public class Lawyer {

    private UUID id;
    private UUID userId;

    private String oabNumber;
    private String stateBar;
    private String bio;

    private LawyerLevel level;
    private boolean verified;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Lawyer() {
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

    public LawyerLevel getLevel() {
        return level;
    }

    public void setLevel(LawyerLevel level) {
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void addExperience(LawyerExperience experience) {
    }
}
package com.jusconnect.lawyers.application.dto.request;

import com.jusconnect.lawyers.domain.enums.LawyerLevel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CreateLawyerRequest {

    @NotNull
    private UUID userId;

    @NotBlank
    private String oabNumber;

    @NotBlank
    private String stateBar;

    private String bio;

    @NotNull
    private LawyerLevel level;

    public CreateLawyerRequest() {
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
}
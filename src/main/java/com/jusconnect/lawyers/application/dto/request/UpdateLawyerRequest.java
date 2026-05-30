package com.jusconnect.lawyers.application.dto.request;

import com.jusconnect.lawyers.domain.enums.LawyerLevel;

public class UpdateLawyerRequest {

    private String bio;
    private LawyerLevel level;

    public UpdateLawyerRequest() {
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
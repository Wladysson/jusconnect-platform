package com.jusconnect.users.application.dto.request;

import jakarta.validation.constraints.NotNull;

import com.jusconnect.users.domain.enums.LawyerSpecialty;

public class UpdateLawyerProfileRequest {

    @NotNull
    private LawyerSpecialty specialty;

    private String bio;

    private String oabNumber;

    public UpdateLawyerProfileRequest() {
    }

    public LawyerSpecialty getSpecialty() {
        return specialty;
    }

    public String getBio() {
        return bio;
    }

    public String getOabNumber() {
        return oabNumber;
    }
}
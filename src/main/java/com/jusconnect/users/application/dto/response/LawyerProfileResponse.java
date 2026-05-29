package com.jusconnect.users.application.dto.response;

import java.util.UUID;

public class LawyerProfileResponse {

    private UUID id;
    private String oabNumber;
    private String specialty;
    private String bio;

    public LawyerProfileResponse() {
    }

    public LawyerProfileResponse(
            UUID id,
            String oabNumber,
            String specialty,
            String bio
    ) {
        this.id = id;
        this.oabNumber = oabNumber;
        this.specialty = specialty;
        this.bio = bio;
    }

    public LawyerProfileResponse(UUID id, String oabNumber, String state, String specialty, String bio) {
    }

    public UUID getId() {
        return id;
    }

    public String getOabNumber() {
        return oabNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getBio() {
        return bio;
    }
}
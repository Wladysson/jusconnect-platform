package com.jusconnect.users.domain.model;

import java.util.UUID;

public class LawyerProfile {

    private UUID id;
    private UUID userId;

    private String oabNumber;
    private String state;
    private String specialty;
    private String bio;

    public LawyerProfile() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
package com.jusconnect.users.domain.model;

import java.util.UUID;

public class LawyerProfile {

    private UUID oabNumber;
    private String state;
    private String specialty;

    public LawyerProfile() {
    }

    public UUID getOabNumber() {
        return oabNumber;
    }

    public void setOabNumber(UUID oabNumber) {
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
}
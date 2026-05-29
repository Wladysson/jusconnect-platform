package com.jusconnect.users.domain.model;

public class ClientProfile {

    private String occupation;
    private String company;

    public ClientProfile() {
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
package com.jusconnect.lawyers.application.dto.request;

public class SearchLawyerRequest {

    private String specialty;
    private String stateBar;
    private String city;
    private Boolean online;

    public SearchLawyerRequest() {
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getStateBar() {
        return stateBar;
    }

    public void setStateBar(String stateBar) {
        this.stateBar = stateBar;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
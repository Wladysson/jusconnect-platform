package com.jusconnect.users.domain.model;

import java.util.UUID;

public class ClientProfile {

    private UUID id;
    private UUID userId;

    private String cpf;
    private String phone;

    private String occupation;
    private String company;

    public ClientProfile() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(
            UUID userId
    ) {
        this.userId = userId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(
            String cpf
    ) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(
            String phone
    ) {
        this.phone = phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(
            String occupation
    ) {
        this.occupation = occupation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(
            String company
    ) {
        this.company = company;
    }
}
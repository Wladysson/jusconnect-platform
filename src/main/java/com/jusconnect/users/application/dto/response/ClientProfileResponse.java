package com.jusconnect.users.application.dto.response;

import java.util.UUID;

public class ClientProfileResponse {

    private UUID id;
    private String cpf;
    private String phone;

    public ClientProfileResponse() {
    }

    public ClientProfileResponse(
            UUID id,
            String cpf,
            String phone
    ) {
        this.id = id;
        this.cpf = cpf;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }
}
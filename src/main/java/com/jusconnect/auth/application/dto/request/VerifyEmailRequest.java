package com.jusconnect.auth.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public class VerifyEmailRequest {

    @NotBlank(message = "Token de verificação é obrigatório")
    private String token;

    public VerifyEmailRequest() {
    }

    public VerifyEmailRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
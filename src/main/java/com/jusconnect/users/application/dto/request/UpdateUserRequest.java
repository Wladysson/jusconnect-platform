package com.jusconnect.users.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public class UpdateUserRequest {

    @NotBlank
    private String name;

    private String phone;

    public UpdateUserRequest() {
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
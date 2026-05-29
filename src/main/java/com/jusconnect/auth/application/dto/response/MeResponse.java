package com.jusconnect.auth.application.dto.response;

import java.util.UUID;

public class MeResponse {

    private UUID id;
    private String email;
    private boolean emailVerified;
    private boolean active;

    public MeResponse() {
    }

    public MeResponse(
            UUID id,
            String email,
            boolean emailVerified,
            boolean active
    ) {
        this.id = id;
        this.email = email;
        this.emailVerified = emailVerified;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
package com.jusconnect.auth.application.dto.response;

import java.util.List;
import java.util.UUID;

public class MeResponse {

    private UUID id;

    private String email;

    private Boolean emailVerified;

    private List<String> roles;

    private List<String> permissions;

    public MeResponse() {
    }

    public MeResponse(
            UUID id,
            String email,
            Boolean emailVerified,
            List<String> roles,
            List<String> permissions
    ) {
        this.id = id;
        this.email = email;
        this.emailVerified = emailVerified;
        this.roles = roles;
        this.permissions = permissions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(
            String email
    ) {
        this.email = email;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(
            Boolean emailVerified
    ) {
        this.emailVerified = emailVerified;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(
            List<String> roles
    ) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(
            List<String> permissions
    ) {
        this.permissions = permissions;
    }
}
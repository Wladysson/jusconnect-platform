package com.jusconnect.shared.security;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.UUID;

@RequestScoped
public class CurrentUser {

    @Inject
    JsonWebToken jwt;

    public UUID getUserId() {

        if (jwt == null || jwt.getSubject() == null) {
            return null;
        }

        return UUID.fromString(jwt.getSubject());
    }

    public String getEmail() {
        return jwt.getClaim("email");
    }

    public String getName() {
        return jwt.getName();
    }

    public boolean hasRole(String role) {
        return jwt.getGroups().contains(role);
    }
}
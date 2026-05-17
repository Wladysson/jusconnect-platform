package com.jusconnect.shared.security;

import java.security.Principal;
import java.util.Set;
import java.util.UUID;

public class JwtPrincipal implements Principal {

    private final UUID userId;

    private final String email;

    private final Set<String> roles;

    public JwtPrincipal(
            UUID userId,
            String email,
            Set<String> roles
    ) {
        this.userId = userId;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public String getName() {
        return email;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public boolean hasRole(String role) {
        return roles.contains(role);
    }
}
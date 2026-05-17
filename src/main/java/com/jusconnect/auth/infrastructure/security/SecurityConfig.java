package com.jusconnect.auth.infrastructure.security;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class SecurityConfig {

    @ConfigProperty(name = "security.jwt-secret")
    String jwtSecret;

    @ConfigProperty(name = "security.jwt-expiration")
    Long jwtExpiration;

    @ConfigProperty(name = "security.issuer")
    String issuer;

    public String getJwtSecret() {
        return jwtSecret;
    }

    public Long getJwtExpiration() {
        return jwtExpiration;
    }

    public String getIssuer() {
        return issuer;
    }
}
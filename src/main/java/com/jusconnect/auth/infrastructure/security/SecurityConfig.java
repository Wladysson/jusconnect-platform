package com.jusconnect.auth.infrastructure.security;

import io.quarkus.arc.config.ConfigProperties;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigProperties(prefix = "security")
public class SecurityConfig {

    public String jwtSecret;

    public Long jwtExpiration;

    public String issuer;

}
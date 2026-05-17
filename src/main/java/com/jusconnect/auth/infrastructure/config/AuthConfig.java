package com.jusconnect.auth.infrastructure.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "auth")
public interface AuthConfig {

    Jwt jwt();

    interface Jwt {

        String issuer();

        Long expiration();

        String secret();

    }
}
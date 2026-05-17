package com.jusconnect.auth.infrastructure.security;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import com.jusconnect.auth.domain.model.RefreshToken;
import com.jusconnect.auth.domain.model.Role;
import com.jusconnect.auth.domain.model.UserCredential;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class JwtService {

    @ConfigProperty(name = "jwt.expiration")
    Long expiration;

    public String generateAccessToken(UserCredential credential) {

        Set<String> roles = credential.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        return Jwt.issuer("jusconnect")
                .subject(credential.getId().toString())
                .groups(roles)
                .expiresIn(Duration.ofSeconds(expiration))
                .sign();
    }

    public String generateTokenFromRefreshToken(
            RefreshToken refreshToken
    ) {

        return Jwt.issuer("jusconnect")
                .subject(refreshToken.getUserCredentialId().toString())
                .expiresIn(Duration.ofSeconds(expiration))
                .sign();
    }

    public Long getExpirationInSeconds() {
        return expiration;
    }
}
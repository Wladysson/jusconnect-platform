package com.jusconnect.auth.application.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import jusconnect.auth.application.dto.response.LoginResponse;
import jusconnect.auth.application.dto.response.TokenResponse;
import jusconnect.auth.domain.model.RefreshToken;
import jusconnect.auth.domain.model.Role;
import jusconnect.auth.domain.model.UserCredential;

import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class AuthMapper {

    public LoginResponse toLoginResponse(
            UserCredential credential,
            String accessToken,
            RefreshToken refreshToken,
            Long expiresIn
    ) {

        Set<String> roles = credential.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        return new LoginResponse(
                credential.getUserId(),
                accessToken,
                refreshToken.getToken(),
                "Bearer",
                expiresIn,
                roles
        );
    }

    public TokenResponse toTokenResponse(
            String accessToken,
            RefreshToken refreshToken,
            Long expiresIn
    ) {

        return new TokenResponse(
                accessToken,
                refreshToken.getToken(),
                "Bearer",
                expiresIn
        );
    }
}
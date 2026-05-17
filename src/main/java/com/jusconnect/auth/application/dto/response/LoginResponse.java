package com.jusconnect.auth.application.dto.response;

import java.util.Set;
import java.util.UUID;

public class LoginResponse {

    private UUID userId;

    private String accessToken;

    private String refreshToken;

    private String tokenType;

    private Long expiresIn;

    private Set<String> roles;

    public LoginResponse() {
    }

    public LoginResponse(
            UUID userId,
            String accessToken,
            String refreshToken,
            String tokenType,
            Long expiresIn,
            Set<String> roles
    ) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.roles = roles;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
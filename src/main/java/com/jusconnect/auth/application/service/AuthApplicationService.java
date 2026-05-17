package com.jusconnect.auth.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import com.jusconnect.auth.application.dto.request.LoginRequest;
import com.jusconnect.auth.application.dto.request.RefreshTokenRequest;
import com.jusconnect.auth.application.dto.request.RegisterRequest;
import com.jusconnect.auth.application.dto.response.LoginResponse;
import com.jusconnect.auth.application.dto.response.TokenResponse;
import com.jusconnect.auth.application.usecase.LoginUseCase;
import com.jusconnect.auth.application.usecase.LogoutUseCase;
import com.jusconnect.auth.application.usecase.RefreshTokenUseCase;
import com.jusconnect.auth.application.usecase.RegisterUseCase;
import com.jusconnect.auth.domain.model.UserCredential;

import java.util.UUID;

@ApplicationScoped
public class AuthApplicationService {

    private final LoginUseCase loginUseCase;

    private final RegisterUseCase registerUseCase;

    private final LogoutUseCase logoutUseCase;

    private final RefreshTokenUseCase refreshTokenUseCase;

    public AuthApplicationService(
            LoginUseCase loginUseCase,
            RegisterUseCase registerUseCase,
            LogoutUseCase logoutUseCase,
            RefreshTokenUseCase refreshTokenUseCase
    ) {
        this.loginUseCase = loginUseCase;
        this.registerUseCase = registerUseCase;
        this.logoutUseCase = logoutUseCase;
        this.refreshTokenUseCase = refreshTokenUseCase;
    }

    public LoginResponse login(LoginRequest request) {
        return loginUseCase.execute(request);
    }

    public UserCredential register(RegisterRequest request) {
        return registerUseCase.execute(request);
    }

    public void logout(UUID userCredentialId) {
        logoutUseCase.execute(userCredentialId);
    }

    public TokenResponse refreshToken(RefreshTokenRequest request) {
        return refreshTokenUseCase.execute(request);
    }
}
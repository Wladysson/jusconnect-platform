package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jusconnect.auth.application.dto.request.LoginRequest;
import jusconnect.auth.application.dto.response.LoginResponse;
import jusconnect.auth.application.mapper.AuthMapper;
import jusconnect.auth.domain.model.RefreshToken;
import jusconnect.auth.domain.model.UserCredential;
import jusconnect.auth.domain.service.AuthDomainService;
import jusconnect.auth.infrastructure.security.JwtService;
import jusconnect.auth.infrastructure.security.PasswordEncoder;

@ApplicationScoped
public class LoginUseCase {

    private final AuthDomainService authDomainService;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthMapper authMapper;

    public LoginUseCase(
            AuthDomainService authDomainService,
            JwtService jwtService,
            PasswordEncoder passwordEncoder,
            AuthMapper authMapper
    ) {
        this.authDomainService = authDomainService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authMapper = authMapper;
    }

    public LoginResponse execute(LoginRequest request) {

        String passwordHash = passwordEncoder.encode(request.getPassword());

        UserCredential credential = authDomainService.validateCredentials(
                request.getEmail(),
                passwordHash
        );

        String accessToken = jwtService.generateAccessToken(credential);

        RefreshToken refreshToken = authDomainService
                .createRefreshToken(credential.getId());

        return authMapper.toLoginResponse(
                credential,
                accessToken,
                refreshToken,
                jwtService.getExpirationInSeconds()
        );
    }
}
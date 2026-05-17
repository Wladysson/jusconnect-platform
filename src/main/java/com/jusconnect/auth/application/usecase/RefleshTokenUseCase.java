package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jusconnect.auth.application.dto.request.RefreshTokenRequest;
import jusconnect.auth.application.dto.response.TokenResponse;
import jusconnect.auth.application.mapper.AuthMapper;
import jusconnect.auth.domain.model.RefreshToken;
import jusconnect.auth.domain.repository.TokenRepository;
import jusconnect.auth.infrastructure.security.JwtService;

@ApplicationScoped
public class RefreshTokenUseCase {

    private final TokenRepository tokenRepository;

    private final JwtService jwtService;

    private final AuthMapper authMapper;

    public RefreshTokenUseCase(
            TokenRepository tokenRepository,
            JwtService jwtService,
            AuthMapper authMapper
    ) {
        this.tokenRepository = tokenRepository;
        this.jwtService = jwtService;
        this.authMapper = authMapper;
    }

    public TokenResponse execute(RefreshTokenRequest request) {

        RefreshToken refreshToken = tokenRepository
                .findByToken(request.getRefreshToken())
                .orElseThrow(() ->
                        new IllegalArgumentException("Refresh token inválido")
                );

        if (!refreshToken.isActive() || refreshToken.isExpired()) {
            throw new IllegalArgumentException("Refresh token expirado");
        }

        String newAccessToken = jwtService
                .generateTokenFromRefreshToken(refreshToken);

        return authMapper.toTokenResponse(
                newAccessToken,
                refreshToken,
                jwtService.getExpirationInSeconds()
        );
    }
}
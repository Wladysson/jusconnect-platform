package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import com.jusconnect.auth.domain.service.AuthDomainService;

import java.util.UUID;

@ApplicationScoped
public class LogoutUseCase {

    private final AuthDomainService authDomainService;

    public LogoutUseCase(AuthDomainService authDomainService) {
        this.authDomainService = authDomainService;
    }

    public void execute(UUID userCredentialId) {
        authDomainService.revokeUserTokens(userCredentialId);
    }
}
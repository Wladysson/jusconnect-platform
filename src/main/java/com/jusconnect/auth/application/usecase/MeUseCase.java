package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.jusconnect.auth.application.dto.response.MeResponse;
import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.domain.repository.AuthRepository;

import java.util.UUID;

@ApplicationScoped
public class MeUseCase {

    @Inject
    AuthRepository authRepository;

    public MeResponse execute(
            UUID userId
    ) {

        UserCredential user =
                authRepository.findById(userId)
                        .orElseThrow();

        return new MeResponse(
                user.getId(),
                user.getEmail(),
                user.getEmailVerified(),
                user.getActive()
        );
    }
}
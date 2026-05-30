package com.jusconnect.users.application.usecase;

import com.jusconnect.users.application.dto.request.UpdateLawyerProfileRequest;
import com.jusconnect.users.domain.model.LawyerProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;

import java.util.UUID;

@ApplicationScoped
public class UpdateLawyerProfileUseCase {

    public void execute() {
        // implementação futura (profile service + repository)
    }

    public LawyerProfile execute(UUID userId, @Valid UpdateLawyerProfileRequest request) {
        return null;
    }
}
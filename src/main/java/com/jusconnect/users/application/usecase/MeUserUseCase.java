package com.jusconnect.users.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.users.domain.model.User;
import com.jusconnect.users.domain.repository.UserRepository;

import java.util.UUID;

@ApplicationScoped
public class MeUserUseCase {

    @Inject
    UserRepository userRepository;

    public User execute(UUID userId) {

        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
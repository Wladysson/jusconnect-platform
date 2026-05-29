package com.jusconnect.users.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.users.domain.model.User;
import com.jusconnect.users.domain.repository.UserRepository;

import java.util.UUID;

@ApplicationScoped
public class ActivateUserUseCase {

    @Inject
    UserRepository userRepository;

    public User execute(UUID userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.activate();

        return userRepository.save(user);
    }
}
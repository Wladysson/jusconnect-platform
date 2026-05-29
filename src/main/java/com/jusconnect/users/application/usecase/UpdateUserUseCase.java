package com.jusconnect.users.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.users.domain.model.User;
import com.jusconnect.users.domain.repository.UserRepository;
import com.jusconnect.users.application.dto.request.UpdateUserRequest;

import java.util.UUID;

@ApplicationScoped
public class UpdateUserUseCase {

    @Inject
    UserRepository userRepository;

    public User execute(UUID userId, UpdateUserRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(request.getName());
        user.setUpdatedAt(java.time.LocalDateTime.now());

        return userRepository.save(user);
    }
}
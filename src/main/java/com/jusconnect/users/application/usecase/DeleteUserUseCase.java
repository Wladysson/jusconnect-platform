package com.jusconnect.users.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.users.domain.repository.UserRepository;

import java.util.UUID;

@ApplicationScoped
public class DeleteUserUseCase {

    @Inject
    UserRepository userRepository;

    public void execute(UUID userId) {
        userRepository.deleteById(userId);
    }
}
package com.jusconnect.users.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.users.domain.model.User;
import com.jusconnect.users.domain.repository.UserRepository;
import com.jusconnect.users.domain.service.UserDomainService;
import com.jusconnect.users.application.dto.request.CreateUserRequest;

@ApplicationScoped
public class CreateUserUseCase {

    @Inject
    UserRepository userRepository;

    @Inject
    UserDomainService userDomainService;

    public User execute(CreateUserRequest request) {

        User user = userDomainService.createUser(
                request.getName(),
                request.getEmail(),
                request.getType()
        );

        user.setPasswordHash(request.getPassword()); // depois troca por encoder

        return userRepository.save(user);
    }
}
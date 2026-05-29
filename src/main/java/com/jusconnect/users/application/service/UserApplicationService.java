package com.jusconnect.users.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.users.application.dto.request.CreateUserRequest;
import com.jusconnect.users.application.dto.request.UpdateUserRequest;

import com.jusconnect.users.application.dto.response.UserResponse;
import com.jusconnect.users.application.dto.response.UserSummaryResponse;

import com.jusconnect.users.application.mapper.UserMapper;

import com.jusconnect.users.application.usecase.CreateUserUseCase;
import com.jusconnect.users.application.usecase.UpdateUserUseCase;
import com.jusconnect.users.application.usecase.GetUserByIdUseCase;
import com.jusconnect.users.application.usecase.DeleteUserUseCase;
import com.jusconnect.users.application.usecase.ActivateUserUseCase;

import com.jusconnect.users.domain.model.User;

import java.util.UUID;

@ApplicationScoped
public class UserApplicationService {

    @Inject
    CreateUserUseCase createUserUseCase;

    @Inject
    UpdateUserUseCase updateUserUseCase;

    @Inject
    GetUserByIdUseCase getUserByIdUseCase;

    @Inject
    DeleteUserUseCase deleteUserUseCase;

    @Inject
    ActivateUserUseCase activateUserUseCase;

    @Inject
    UserMapper userMapper;

    public UserResponse create(CreateUserRequest request) {

        User user = createUserUseCase.execute(request);

        return userMapper.toResponse(user);
    }

    public UserResponse update(UUID userId, UpdateUserRequest request) {

        User user = updateUserUseCase.execute(userId, request);

        return userMapper.toResponse(user);
    }

    public UserResponse getById(UUID userId) {

        User user = getUserByIdUseCase.execute(userId);

        return userMapper.toResponse(user);
    }

    public void delete(UUID userId) {
        deleteUserUseCase.execute(userId);
    }

    public UserResponse activate(UUID userId) {

        User user = activateUserUseCase.execute(userId);

        return userMapper.toResponse(user);
    }

    public UserSummaryResponse toSummary(User user) {
        return userMapper.toSummary(user);
    }
}
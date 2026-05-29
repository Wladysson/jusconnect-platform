package com.jusconnect.users.domain.service;

import com.jusconnect.users.domain.model.User;
import com.jusconnect.users.domain.enums.UserStatus;
import com.jusconnect.users.domain.enums.UserType;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class UserDomainService {

    public User createUser(
            String name,
            String email,
            UserType type
    ) {

        User user = new User();

        user.setId(UUID.randomUUID());
        user.setName(name);
        user.setEmail(email);

        user.setStatus(UserStatus.PENDING);

        if (type == UserType.CLIENT) {
            user.setClientProfile(null); // pode ser preenchido depois
        }

        if (type == UserType.LAWYER) {
            user.setLawyerProfile(null); // pode ser preenchido depois
        }

        return user;
    }

    public void activateUser(User user) {

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalStateException("Email é obrigatório para ativar o usuário");
        }

        user.activate();
    }

    public void deactivateUser(User user) {
        user.deactivate();
    }

    public void suspendUser(User user, String reason) {

        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("Motivo da suspensão é obrigatório");
        }

        user.suspend();
    }

    public void validateUser(User user) {

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalStateException("Email inválido");
        }

        if (user.getName() == null || user.getName().isBlank()) {
            throw new IllegalStateException("Nome inválido");
        }
    }
}
package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import com.jusconnect.auth.application.dto.request.RegisterRequest;
import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.domain.repository.AuthRepository;
import com.jusconnect.auth.infrastructure.security.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class RegisterUseCase {

    private final AuthRepository authRepository;

    private final PasswordEncoder passwordEncoder;

    public RegisterUseCase(
            AuthRepository authRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserCredential execute(RegisterRequest request) {

        if (authRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        UserCredential credential = new UserCredential();

        credential.setId(UUID.randomUUID());
        credential.setUserId(UUID.randomUUID());

        credential.setEmail(request.getEmail());

        credential.setPasswordHash(
                passwordEncoder.encode(request.getPassword())
        );

        credential.setCreatedAt(LocalDateTime.now());
        credential.setUpdatedAt(LocalDateTime.now());

        credential.activate();

        return authRepository.save(credential);
    }
}
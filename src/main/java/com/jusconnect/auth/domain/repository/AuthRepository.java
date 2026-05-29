package com.jusconnect.auth.domain.repository;

import com.jusconnect.auth.domain.model.UserCredential;

import java.util.Optional;
import java.util.UUID;

public interface AuthRepository {

    Optional<UserCredential> findById(UUID id);

    Optional<UserCredential> findByEmail(String email);

    boolean existsByEmail(String email);

    UserCredential save(UserCredential credential);

    UserCredential update(UserCredential user);

    void deleteById(UUID id);

}
package com.jusconnect.users.domain.repository;

import com.jusconnect.users.domain.model.LawyerProfile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LawyerRepository {

    LawyerProfile save(LawyerProfile lawyerProfile);

    Optional<LawyerProfile> findById(UUID id);

    Optional<LawyerProfile> findByUserId(UUID userId);

    List<LawyerProfile> findBySpecialty(String specialty);

    void deleteById(UUID id);
}
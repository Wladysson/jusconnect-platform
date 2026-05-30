package com.jusconnect.lawyers.domain.repository;

import com.jusconnect.lawyers.domain.model.LawyerAvailability;

import java.util.Optional;
import java.util.UUID;

public interface AvailabilityRepository {

    void save(
            LawyerAvailability availability
    );

    Optional<LawyerAvailability> findById(
            UUID id
    );

    void deleteById(
            UUID id
    );
}
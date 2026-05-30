package com.jusconnect.lawyers.domain.repository;

import com.jusconnect.lawyers.domain.model.LawyerAvailability;

import java.util.List;
import java.util.UUID;

public interface AvailabilityRepository {

    LawyerAvailability save(
            LawyerAvailability availability
    );

    List<LawyerAvailability> findByLawyerId(
            UUID lawyerId
    );

    void deleteByLawyerId(
            UUID lawyerId
    );
}
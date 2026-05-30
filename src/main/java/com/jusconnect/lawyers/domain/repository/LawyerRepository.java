package com.jusconnect.lawyers.domain.repository;

import com.jusconnect.lawyers.domain.model.Lawyer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LawyerRepository {

    Lawyer save(
            Lawyer lawyer
    );

    Optional<Lawyer> findById(
            UUID id
    );

    Optional<Lawyer> findByUserId(
            UUID userId
    );

    List<Lawyer> findAll();

    List<Lawyer> search(
            String specialty,
            String stateBar
    );

    void deleteById(
            UUID id
    );

    boolean existsByUserId(
            UUID userId
    );

    List<Lawyer> search(String specialty, String stateBar, String city, Boolean online);
}
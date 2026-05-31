package com.jusconnect.leads.domain.repository;

import com.jusconnect.leads.domain.model.Lead;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeadRepository {

    Lead save(
            Lead lead
    );

    Optional<Lead> findById(
            UUID id
    );

    List<Lead> findAll();

    List<Lead> search(
            String legalArea,
            String status
    );

    boolean existsByEmail(
            String email
    );

    void deleteById(
            UUID id
    );
}
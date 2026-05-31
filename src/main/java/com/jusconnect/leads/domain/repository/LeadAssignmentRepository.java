package com.jusconnect.leads.domain.repository;

import com.jusconnect.leads.domain.model.LeadAssignment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeadAssignmentRepository {

    LeadAssignment save(
            LeadAssignment assignment
    );

    Optional<LeadAssignment> findById(
            UUID id
    );

    Optional<LeadAssignment> findByLeadId(
            UUID leadId
    );

    List<LeadAssignment> findByLawyerId(
            UUID lawyerId
    );

    void deleteById(
            UUID id
    );
}
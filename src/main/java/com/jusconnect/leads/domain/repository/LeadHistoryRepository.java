package com.jusconnect.leads.domain.repository;

import com.jusconnect.leads.domain.model.LeadHistory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeadHistoryRepository {

    LeadHistory save(
            LeadHistory history
    );

    Optional<LeadHistory> findById(
            UUID id
    );

    List<LeadHistory> findByLeadId(
            UUID leadId
    );

    void deleteById(
            UUID id
    );
}
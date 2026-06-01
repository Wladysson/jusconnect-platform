package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.domain.model.LeadHistory;
import com.jusconnect.leads.domain.repository.LeadHistoryRepository;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GetLeadHistoryUseCase {

    @Inject
    LeadHistoryRepository historyRepository;

    public List<LeadHistory> execute(
            UUID leadId
    ) {

        return historyRepository.findByLeadId(
                leadId
        );
    }
}
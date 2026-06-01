package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.application.dto.request.UpdateLeadPriorityRequest;

import com.jusconnect.leads.domain.enums.LeadPriority;
import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.repository.LeadRepository;

import java.util.UUID;

@ApplicationScoped
public class UpdateLeadPriorityUseCase {

    @Inject
    LeadRepository leadRepository;

    public Lead execute(
            UUID leadId,
            UpdateLeadPriorityRequest request
    ) {

        Lead lead =
                leadRepository.findById(
                                leadId
                        )
                        .orElseThrow(
                                () -> new IllegalArgumentException(
                                        "Lead não encontrado"
                                )
                        );

        lead.setPriority(
                LeadPriority.valueOf(
                        request.getPriority()
                                .toUpperCase()
                )
        );

        return leadRepository.save(
                lead
        );
    }
}
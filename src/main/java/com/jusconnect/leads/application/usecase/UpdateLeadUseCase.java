package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.application.dto.request.UpdateLeadRequest;

import com.jusconnect.leads.domain.enums.LeadStatus;
import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.repository.LeadRepository;
import com.jusconnect.leads.domain.service.LeadDomainService;

import java.util.UUID;

@ApplicationScoped
public class UpdateLeadUseCase {

    @Inject
    LeadRepository leadRepository;

    @Inject
    LeadDomainService domainService;

    public Lead execute(
            UUID id,
            UpdateLeadRequest request
    ) {

        Lead lead =
                leadRepository.findById(
                                id
                        )
                        .orElseThrow(
                                () -> new IllegalArgumentException(
                                        "Lead não encontrado"
                                )
                        );

        lead.setName(
                request.getName()
        );

        lead.setEmail(
                request.getEmail()
        );

        lead.setPhone(
                request.getPhone()
        );

        lead.setLegalArea(
                request.getLegalArea()
        );

        if (request.getStatus() != null) {

            lead.setStatus(
                    LeadStatus.valueOf(
                            request.getStatus()
                                    .toUpperCase()
                    )
            );
        }

        domainService.validateLead(
                lead
        );

        return leadRepository.save(
                lead
        );
    }
}
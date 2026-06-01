package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.application.dto.request.CreateLeadRequest;

import com.jusconnect.leads.domain.enums.LeadPriority;
import com.jusconnect.leads.domain.enums.LeadSource;
import com.jusconnect.leads.domain.enums.LeadStatus;
import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.repository.LeadRepository;
import com.jusconnect.leads.domain.service.LeadDomainService;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class CreateLeadUseCase {

    @Inject
    LeadRepository leadRepository;

    @Inject
    LeadDomainService domainService;

    public Lead execute(
            CreateLeadRequest request
    ) {

        if (leadRepository.existsByEmail(
                request.getEmail()
        )) {

            throw new IllegalStateException(
                    "Lead já cadastrado"
            );
        }

        Lead lead =
                new Lead();

        lead.setId(
                UUID.randomUUID()
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

        lead.setSource(
                LeadSource.valueOf(
                        request.getSource()
                                .toUpperCase()
                )
        );

        lead.setStatus(
                LeadStatus.NEW
        );

        lead.setPriority(
                LeadPriority.MEDIUM
        );

        lead.setCreatedAt(
                LocalDateTime.now()
        );

        domainService.validateLead(
                lead
        );

        domainService.definePriority(
                lead
        );

        return leadRepository.save(
                lead
        );
    }
}
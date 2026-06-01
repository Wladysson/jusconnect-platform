package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.model.LeadScore;
import com.jusconnect.leads.domain.repository.LeadRepository;
import com.jusconnect.leads.domain.service.LeadDomainService;

import java.util.UUID;

@ApplicationScoped
public class CalculateLeadScoreUseCase {

    @Inject
    LeadRepository leadRepository;

    @Inject
    LeadDomainService domainService;

    public LeadScore execute(
            UUID leadId
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

        return domainService.calculateScore(
                lead
        );
    }
}
package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.repository.LeadRepository;

import java.util.UUID;

@ApplicationScoped
public class DeleteLeadUseCase {

    @Inject
    LeadRepository leadRepository;

    public void execute(
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

        leadRepository.deleteById(
                lead.getId()
        );
    }
}
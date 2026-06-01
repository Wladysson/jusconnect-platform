package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.repository.LeadRepository;

import java.util.UUID;

@ApplicationScoped
public class GetLeadByIdUseCase {

    @Inject
    LeadRepository leadRepository;

    public Lead execute(
            UUID id
    ) {

        return leadRepository.findById(
                        id
                )
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Lead não encontrado"
                        )
                );
    }
}
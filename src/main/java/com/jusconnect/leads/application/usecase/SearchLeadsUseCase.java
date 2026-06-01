package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.application.dto.request.SearchLeadRequest;

import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.repository.LeadRepository;

import java.util.List;

@ApplicationScoped
public class SearchLeadsUseCase {

    @Inject
    LeadRepository leadRepository;

    public List<Lead> execute(
            SearchLeadRequest request
    ) {

        return leadRepository.search(
                request.getLegalArea(),
                request.getStatus()
        );
    }
}
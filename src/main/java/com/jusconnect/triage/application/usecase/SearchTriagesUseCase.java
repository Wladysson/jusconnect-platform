package com.jusconnect.triage.application.usecase;

import com.jusconnect.triage.application.dto.request.SearchTriageRequest;
import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.domain.repository.TriageRepository;

import java.util.List;

public class SearchTriagesUseCase {

    private final TriageRepository triageRepository;

    public SearchTriagesUseCase(
            TriageRepository triageRepository
    ) {
        this.triageRepository = triageRepository;
    }

    public List<Triage> execute(
            SearchTriageRequest request
    ) {

        return triageRepository.search(
                request.getStatus(),
                request.getLegalArea(),
                request.getPriority()
        );
    }
}
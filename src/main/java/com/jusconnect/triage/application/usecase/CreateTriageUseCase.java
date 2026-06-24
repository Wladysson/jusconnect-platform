package com.jusconnect.triage.application.usecase;

import com.jusconnect.triage.application.dto.request.CreateTriageRequest;
import com.jusconnect.triage.application.mapper.TriageMapper;
import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.domain.repository.TriageRepository;
import com.jusconnect.triage.domain.service.TriageDomainService;

public class CreateTriageUseCase {

    private final TriageRepository triageRepository;

    private final TriageDomainService triageDomainService;

    public CreateTriageUseCase(
            TriageRepository triageRepository,
            TriageDomainService triageDomainService
    ) {

        this.triageRepository = triageRepository;
        this.triageDomainService = triageDomainService;
    }

    public Triage execute(
            CreateTriageRequest request
    ) {

        Triage triage =
                TriageMapper.toDomain(
                        request
                );

        triageDomainService.validate(
                triage
        );

        return triageRepository.save(
                triage
        );
    }
}
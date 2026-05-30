package com.jusconnect.lawyers.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;
import com.jusconnect.lawyers.application.dto.request.SearchLawyerRequest;

import java.util.List;

@ApplicationScoped
public class SearchLawyersUseCase {

    @Inject
    LawyerRepository lawyerRepository;

    public List<Lawyer> execute(
            SearchLawyerRequest request
    ) {

        return lawyerRepository.search(
                request.getSpecialty(),
                request.getStateBar(),
                request.getCity(),
                request.getOnline()
        );
    }
}
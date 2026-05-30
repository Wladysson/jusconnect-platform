package com.jusconnect.lawyers.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;
import com.jusconnect.lawyers.domain.service.LawyerDomainService;
import com.jusconnect.lawyers.application.dto.request.CreateLawyerRequest;

import java.util.UUID;

@ApplicationScoped
public class CreateLawyerUseCase {

    @Inject
    LawyerRepository lawyerRepository;

    @Inject
    LawyerDomainService lawyerDomainService;

    public Lawyer execute(
            CreateLawyerRequest request
    ) {

        lawyerDomainService.validateCreate(
                request.getUserId()
        );

        Lawyer lawyer = new Lawyer();

        lawyer.setId(UUID.randomUUID());
        lawyer.setUserId(
                request.getUserId()
        );
        lawyer.setOabNumber(
                request.getOabNumber()
        );
        lawyer.setStateBar(
                request.getStateBar()
        );
        lawyer.setBio(
                request.getBio()
        );
        lawyer.setLevel(
                request.getLevel()
        );

        lawyerRepository.save(lawyer);

        return lawyer;
    }
}
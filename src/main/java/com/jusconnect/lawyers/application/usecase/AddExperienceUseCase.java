package com.jusconnect.lawyers.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.model.LawyerExperience;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;
import com.jusconnect.lawyers.application.dto.request.AddExperienceRequest;

import java.util.UUID;

@ApplicationScoped
public class AddExperienceUseCase {

    @Inject
    LawyerRepository lawyerRepository;

    public LawyerExperience execute(
            UUID lawyerId,
            AddExperienceRequest request
    ) {

        Lawyer lawyer =
                lawyerRepository
                        .findById(lawyerId)
                        .orElseThrow(() ->
                                new NotFoundException(
                                        "Advogado não encontrado"
                                )
                        );

        LawyerExperience experience =
                new LawyerExperience();

        experience.setId(
                UUID.randomUUID()
        );

        experience.setCompany(
                request.getCompany()
        );

        experience.setRole(
                request.getRole()
        );

        experience.setDescription(
                request.getDescription()
        );

        experience.setStartDate(
                request.getStartDate()
        );

        experience.setEndDate(
                request.getEndDate()
        );

        lawyer.addExperience(
                experience
        );

        lawyerRepository.save(
                lawyer
        );

        return experience;
    }
}
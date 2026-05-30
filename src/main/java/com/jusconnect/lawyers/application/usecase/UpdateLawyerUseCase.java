package com.jusconnect.lawyers.application.usecase;

import com.jusconnect.shared.kernel.exceptions.NotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;
import com.jusconnect.lawyers.application.dto.request.UpdateLawyerRequest;

import java.util.UUID;

@ApplicationScoped
public class UpdateLawyerUseCase {

    @Inject
    LawyerRepository lawyerRepository;

    public Lawyer execute(
            UUID lawyerId,
            UpdateLawyerRequest request
    ) {

        Lawyer lawyer =
                lawyerRepository
                        .findById(lawyerId)
                        .orElseThrow(() ->
                                new NotFoundException(
                                        "Advogado não encontrado"
                                )
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
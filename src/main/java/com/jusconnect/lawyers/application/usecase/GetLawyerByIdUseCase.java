package com.jusconnect.lawyers.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;

import java.util.UUID;

@ApplicationScoped
public class GetLawyerByIdUseCase {

    @Inject
    LawyerRepository lawyerRepository;

    public Lawyer execute(
            UUID lawyerId
    ) {

        return lawyerRepository
                .findById(lawyerId)
                .orElseThrow(() ->
                        new NotFoundException(
                                "Advogado não encontrado"
                        )
                );
    }
}
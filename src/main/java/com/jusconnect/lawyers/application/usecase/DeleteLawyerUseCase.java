package com.jusconnect.lawyers.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import com.jusconnect.lawyers.domain.repository.LawyerRepository;

import java.util.UUID;

@ApplicationScoped
public class DeleteLawyerUseCase {

    @Inject
    LawyerRepository lawyerRepository;

    public void execute(
            UUID lawyerId
    ) {

        boolean exists =
                lawyerRepository
                        .findById(lawyerId)
                        .isPresent();

        if (!exists) {
            throw new NotFoundException(
                    "Advogado não encontrado"
            );
        }

        lawyerRepository.deleteById(
                lawyerId
        );
    }
}
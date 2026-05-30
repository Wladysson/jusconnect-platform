package com.jusconnect.lawyers.domain.service;

import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.lawyers.domain.model.Lawyer;
import com.jusconnect.lawyers.domain.repository.LawyerRepository;

import java.util.UUID;

@ApplicationScoped
public class LawyerDomainService {

    private final LawyerRepository lawyerRepository;

    public LawyerDomainService(
            LawyerRepository lawyerRepository
    ) {
        this.lawyerRepository =
                lawyerRepository;
    }

    public void validateCreate(
            UUID userId
    ) {

        if (
                lawyerRepository
                        .existsByUserId(userId)
        ) {

            throw new RuntimeException(
                    "Usuário já possui perfil de advogado"
            );
        }
    }

    public void validateLawyer(
            Lawyer lawyer
    ) {

        if (lawyer == null) {
            throw new RuntimeException(
                    "Advogado inválido"
            );
        }

        if (
                lawyer.getOabNumber() == null
                        || lawyer.getOabNumber().isBlank()
        ) {

            throw new RuntimeException(
                    "OAB obrigatória"
            );
        }
    }
}
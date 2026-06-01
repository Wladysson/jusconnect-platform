package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.application.dto.request.AssignLeadRequest;

import com.jusconnect.leads.domain.enums.LeadStatus;
import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.model.LeadAssignment;
import com.jusconnect.leads.domain.repository.LeadAssignmentRepository;
import com.jusconnect.leads.domain.repository.LeadRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class AssignLeadUseCase {

    @Inject
    LeadRepository leadRepository;

    @Inject
    LeadAssignmentRepository assignmentRepository;

    public LeadAssignment execute(
            UUID leadId,
            AssignLeadRequest request
    ) {

        Lead lead =
                leadRepository.findById(
                                leadId
                        )
                        .orElseThrow(
                                () -> new IllegalArgumentException(
                                        "Lead não encontrado"
                                )
                        );

        LeadAssignment assignment =
                new LeadAssignment();

        assignment.setId(
                UUID.randomUUID()
        );

        assignment.setLeadId(
                leadId
        );

        assignment.setLawyerId(
                request.getLawyerId()
        );

        assignment.setAssignedAt(
                LocalDateTime.now()
        );

        lead.setStatus(
                LeadStatus.ASSIGNED
        );

        leadRepository.save(
                lead
        );

        return assignmentRepository.save(
                assignment
        );
    }
}
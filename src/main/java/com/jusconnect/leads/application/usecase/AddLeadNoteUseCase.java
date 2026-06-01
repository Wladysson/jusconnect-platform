package com.jusconnect.leads.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.application.dto.request.AddLeadNoteRequest;

import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.model.LeadNote;
import com.jusconnect.leads.domain.repository.LeadRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class AddLeadNoteUseCase {

    @Inject
    LeadRepository leadRepository;

    public LeadNote execute(
            UUID leadId,
            AddLeadNoteRequest request
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

        LeadNote note =
                new LeadNote();

        note.setId(
                UUID.randomUUID()
        );

        note.setLeadId(
                lead.getId()
        );

        note.setNote(
                request.getNote()
        );

        note.setCreatedAt(
                LocalDateTime.now()
        );

        return note;
    }
}
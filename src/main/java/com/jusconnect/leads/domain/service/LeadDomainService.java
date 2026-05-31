package com.jusconnect.leads.domain.service;

import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.leads.domain.enums.LeadPriority;
import com.jusconnect.leads.domain.enums.LeadStatus;
import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.model.LeadScore;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class LeadDomainService {

    public void validateLead(
            Lead lead
    ) {

        if (lead == null) {
            throw new IllegalArgumentException(
                    "Lead inválido"
            );
        }

        if (lead.getEmail() == null ||
                lead.getEmail().isBlank()) {

            throw new IllegalArgumentException(
                    "Email obrigatório"
            );
        }

        if (lead.getName() == null ||
                lead.getName().isBlank()) {

            throw new IllegalArgumentException(
                    "Nome obrigatório"
            );
        }
    }

    public void qualifyLead(
            Lead lead
    ) {

        validateLead(lead);

        lead.setStatus(
                LeadStatus.QUALIFIED
        );
    }

    public void definePriority(
            Lead lead
    ) {

        if (lead.getLegalArea() == null) {

            lead.setPriority(
                    LeadPriority.MEDIUM
            );

            return;
        }

        String area =
                lead.getLegalArea()
                        .toLowerCase();

        if (area.contains("criminal") ||
                area.contains("trabalhista")) {

            lead.setPriority(
                    LeadPriority.HIGH
            );

            return;
        }

        lead.setPriority(
                LeadPriority.MEDIUM
        );
    }

    public LeadScore calculateScore(
            Lead lead
    ) {

        int score = 0;

        if (lead.getEmail() != null) {
            score += 20;
        }

        if (lead.getPhone() != null) {
            score += 20;
        }

        if (lead.getLegalArea() != null) {
            score += 30;
        }

        if (lead.getPriority() ==
                LeadPriority.HIGH) {

            score += 30;
        }

        LeadScore leadScore =
                new LeadScore();

        leadScore.setId(
                UUID.randomUUID()
        );

        leadScore.setLeadId(
                lead.getId()
        );

        leadScore.setScore(
                score
        );

        leadScore.setReason(
                "Score calculado automaticamente"
        );

        leadScore.setCalculatedAt(
                LocalDateTime.now()
        );

        return leadScore;
    }
}
package com.jusconnect.leads.application.mapper;

import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.model.LeadAssignment;
import com.jusconnect.leads.domain.model.LeadHistory;
import com.jusconnect.leads.domain.model.LeadNote;
import com.jusconnect.leads.domain.model.LeadScore;

import com.jusconnect.leads.application.dto.response.LeadResponse;
import com.jusconnect.leads.application.dto.response.LeadSummaryResponse;
import com.jusconnect.leads.application.dto.response.LeadAssignmentResponse;
import com.jusconnect.leads.application.dto.response.LeadHistoryResponse;
import com.jusconnect.leads.application.dto.response.LeadNoteResponse;
import com.jusconnect.leads.application.dto.response.LeadScoreResponse;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LeadMapper {

    public LeadResponse toResponse(
            Lead lead
    ) {

        if (lead == null) {
            return null;
        }

        return new LeadResponse(
                lead.getId(),
                lead.getName(),
                lead.getEmail(),
                lead.getPhone(),
                lead.getLegalArea(),
                String.valueOf(
                        lead.getStatus()
                ),
                String.valueOf(
                        lead.getPriority()
                ),
                String.valueOf(
                        lead.getSource()
                ),
                lead.getCreatedAt()
        );
    }

    public LeadSummaryResponse toSummary(
            Lead lead
    ) {

        if (lead == null) {
            return null;
        }

        return new LeadSummaryResponse(
                lead.getId(),
                lead.getName(),
                String.valueOf(
                        lead.getStatus()
                )
        );
    }

    public LeadAssignmentResponse toResponse(
            LeadAssignment assignment
    ) {

        if (assignment == null) {
            return null;
        }

        return new LeadAssignmentResponse(
                assignment.getId(),
                assignment.getLeadId(),
                assignment.getLawyerId(),
                assignment.getAssignedAt()
        );
    }

    public LeadHistoryResponse toResponse(
            LeadHistory history
    ) {

        if (history == null) {
            return null;
        }

        return new LeadHistoryResponse(
                history.getId(),
                history.getAction(),
                history.getDescription(),
                history.getCreatedAt()
        );
    }

    public LeadNoteResponse toResponse(
            LeadNote note
    ) {

        if (note == null) {
            return null;
        }

        return new LeadNoteResponse(
                note.getId(),
                note.getNote(),
                note.getCreatedAt()
        );
    }

    public LeadScoreResponse toResponse(
            LeadScore score
    ) {

        if (score == null) {
            return null;
        }

        return new LeadScoreResponse(
                score.getId(),
                score.getScore(),
                score.getReason(),
                score.getCalculatedAt()
        );
    }

    public List<LeadResponse> toLeadList(
            List<Lead> leads
    ) {

        if (leads == null) {
            return List.of();
        }

        return leads.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
package com.jusconnect.leads.infrastructure.persistence.mapper;

import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.leads.domain.enums.LeadPriority;
import com.jusconnect.leads.domain.enums.LeadSource;
import com.jusconnect.leads.domain.enums.LeadStatus;

import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.model.LeadAssignment;
import com.jusconnect.leads.domain.model.LeadHistory;
import com.jusconnect.leads.domain.model.LeadNote;
import com.jusconnect.leads.domain.model.LeadScore;

import com.jusconnect.leads.infrastructure.persistence.entity.LeadEntity;
import com.jusconnect.leads.infrastructure.persistence.entity.LeadAssignmentEntity;
import com.jusconnect.leads.infrastructure.persistence.entity.LeadHistoryEntity;
import com.jusconnect.leads.infrastructure.persistence.entity.LeadNoteEntity;
import com.jusconnect.leads.infrastructure.persistence.entity.LeadScoreEntity;

@ApplicationScoped
public class LeadPersistenceMapper {

    public LeadEntity toEntity(
            Lead lead
    ) {

        if (lead == null) {
            return null;
        }

        LeadEntity entity =
                new LeadEntity();

        entity.setId(
                lead.getId()
        );

        entity.setUserId(
                lead.getUserId()
        );

        entity.setName(
                lead.getName()
        );

        entity.setEmail(
                lead.getEmail()
        );

        entity.setPhone(
                lead.getPhone()
        );

        entity.setLegalArea(
                lead.getLegalArea()
        );

        entity.setStatus(
                lead.getStatus().name()
        );

        entity.setSource(
                lead.getSource().name()
        );

        entity.setPriority(
                lead.getPriority().name()
        );

        entity.setCreatedAt(
                lead.getCreatedAt()
        );

        return entity;
    }

    public Lead toDomain(
            LeadEntity entity
    ) {

        if (entity == null) {
            return null;
        }

        Lead lead =
                new Lead();

        lead.setId(
                entity.getId()
        );

        lead.setUserId(
                entity.getUserId()
        );

        lead.setName(
                entity.getName()
        );

        lead.setEmail(
                entity.getEmail()
        );

        lead.setPhone(
                entity.getPhone()
        );

        lead.setLegalArea(
                entity.getLegalArea()
        );

        lead.setStatus(
                LeadStatus.valueOf(
                        entity.getStatus()
                )
        );

        lead.setSource(
                LeadSource.valueOf(
                        entity.getSource()
                )
        );

        lead.setPriority(
                LeadPriority.valueOf(
                        entity.getPriority()
                )
        );

        lead.setCreatedAt(
                entity.getCreatedAt()
        );

        return lead;
    }

    public LeadAssignmentEntity toEntity(
            LeadAssignment assignment
    ) {

        LeadAssignmentEntity entity =
                new LeadAssignmentEntity();

        entity.setId(
                assignment.getId()
        );

        entity.setLeadId(
                assignment.getLeadId()
        );

        entity.setLawyerId(
                assignment.getLawyerId()
        );

        entity.setAssignedAt(
                assignment.getAssignedAt()
        );

        return entity;
    }

    public LeadAssignment toDomain(
            LeadAssignmentEntity entity
    ) {

        LeadAssignment assignment =
                new LeadAssignment();

        assignment.setId(
                entity.getId()
        );

        assignment.setLeadId(
                entity.getLeadId()
        );

        assignment.setLawyerId(
                entity.getLawyerId()
        );

        assignment.setAssignedAt(
                entity.getAssignedAt()
        );

        return assignment;
    }

    public LeadHistory toDomain(
            LeadHistoryEntity entity
    ) {

        LeadHistory history =
                new LeadHistory();

        history.setId(
                entity.getId()
        );

        history.setLeadId(
                entity.getLeadId()
        );

        history.setAction(
                entity.getAction()
        );

        history.setDescription(
                entity.getDescription()
        );

        history.setCreatedAt(
                entity.getCreatedAt()
        );

        return history;
    }

    public LeadNote toDomain(
            LeadNoteEntity entity
    ) {

        LeadNote note =
                new LeadNote();

        note.setId(
                entity.getId()
        );

        note.setLeadId(
                entity.getLeadId()
        );

        note.setNote(
                entity.getNote()
        );

        note.setCreatedAt(
                entity.getCreatedAt()
        );

        return note;
    }

    public LeadScore toDomain(
            LeadScoreEntity entity
    ) {

        LeadScore score =
                new LeadScore();

        score.setId(
                entity.getId()
        );

        score.setLeadId(
                entity.getLeadId()
        );

        score.setScore(
                entity.getScore()
        );

        score.setReason(
                entity.getReason()
        );

        score.setCalculatedAt(
                entity.getCalculatedAt()
        );

        return score;
    }
}
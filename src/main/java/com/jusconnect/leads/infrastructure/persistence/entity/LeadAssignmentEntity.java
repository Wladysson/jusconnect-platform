package com.jusconnect.leads.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lead_assignments")
public class LeadAssignmentEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "lead_id", nullable = false)
    private UUID leadId;

    @Column(name = "lawyer_id", nullable = false)
    private UUID lawyerId;

    @Column(name = "assigned_at")
    private LocalDateTime assignedAt;

    public LeadAssignmentEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
        this.id = id;
    }

    public UUID getLeadId() {
        return leadId;
    }

    public void setLeadId(
            UUID leadId
    ) {
        this.leadId = leadId;
    }

    public UUID getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(
            UUID lawyerId
    ) {
        this.lawyerId = lawyerId;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(
            LocalDateTime assignedAt
    ) {
        this.assignedAt = assignedAt;
    }
}
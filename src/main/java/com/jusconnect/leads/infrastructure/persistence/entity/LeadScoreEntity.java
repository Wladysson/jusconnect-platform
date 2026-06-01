package com.jusconnect.leads.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lead_scores")
public class LeadScoreEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "lead_id", nullable = false)
    private UUID leadId;

    @Column(nullable = false)
    private Integer score;

    @Column(length = 2000)
    private String reason;

    @Column(name = "calculated_at")
    private LocalDateTime calculatedAt;

    public LeadScoreEntity() {
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

    public Integer getScore() {
        return score;
    }

    public void setScore(
            Integer score
    ) {
        this.score = score;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(
            String reason
    ) {
        this.reason = reason;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(
            LocalDateTime calculatedAt
    ) {
        this.calculatedAt = calculatedAt;
    }
}
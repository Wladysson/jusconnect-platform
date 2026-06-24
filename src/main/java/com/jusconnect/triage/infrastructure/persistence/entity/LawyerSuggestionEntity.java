package com.jusconnect.triage.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lawyer_suggestions")
public class LawyerSuggestionEntity {

    @Id
    private UUID id;

    @Column(name = "triage_id")
    private UUID triageId;

    @Column(name = "lawyer_id")
    private UUID lawyerId;

    @Column(name = "compatibility_score")
    private Double compatibilityScore;

    @Column(name = "reason")
    private String reason;

    @Column(name = "recommended_at")
    private LocalDateTime recommendedAt;

    public LawyerSuggestionEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTriageId() {
        return triageId;
    }

    public void setTriageId(UUID triageId) {
        this.triageId = triageId;
    }

    public UUID getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(UUID lawyerId) {
        this.lawyerId = lawyerId;
    }

    public Double getCompatibilityScore() {
        return compatibilityScore;
    }

    public void setCompatibilityScore(Double compatibilityScore) {
        this.compatibilityScore = compatibilityScore;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getRecommendedAt() {
        return recommendedAt;
    }

    public void setRecommendedAt(LocalDateTime recommendedAt) {
        this.recommendedAt = recommendedAt;
    }
}
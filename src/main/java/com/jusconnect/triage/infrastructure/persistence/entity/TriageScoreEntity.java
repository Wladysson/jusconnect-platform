package com.jusconnect.triage.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "triage_scores")
public class TriageScoreEntity {

    @Id
    private UUID id;

    @Column(name = "triage_id")
    private UUID triageId;

    @Column(name = "urgency_score")
    private Integer urgencyScore;

    @Column(name = "complexity_score")
    private Integer complexityScore;

    @Column(name = "business_score")
    private Integer businessScore;

    @Column(name = "final_score")
    private Integer finalScore;

    // getters e setters
}
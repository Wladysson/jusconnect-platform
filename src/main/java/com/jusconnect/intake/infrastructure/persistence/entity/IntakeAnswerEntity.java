package com.jusconnect.intake.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "intake_answers")
public class IntakeAnswerEntity {

    @Id
    private UUID id;

    @Column(name = "intake_id", nullable = false)
    private UUID intakeId;

    @Column(name = "step_id", nullable = false)
    private UUID stepId;

    @Column(nullable = false, length = 4000)
    private String answer;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public IntakeAnswerEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(UUID intakeId) {
        this.intakeId = intakeId;
    }

    public UUID getStepId() {
        return stepId;
    }

    public void setStepId(UUID stepId) {
        this.stepId = stepId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
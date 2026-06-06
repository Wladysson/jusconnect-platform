package com.jusconnect.intake.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class IntakeAnswerResponse {

    private UUID id;
    private UUID stepId;
    private String question;
    private String answer;
    private LocalDateTime createdAt;

    public IntakeAnswerResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
        this.id = id;
    }

    public UUID getStepId() {
        return stepId;
    }

    public void setStepId(
            UUID stepId
    ) {
        this.stepId = stepId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(
            String question
    ) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(
            String answer
    ) {
        this.answer = answer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(
            LocalDateTime createdAt
    ) {
        this.createdAt = createdAt;
    }
}
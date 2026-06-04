package com.jusconnect.intake.application.dto.request;

import java.util.UUID;

public class SubmitAnswerRequest {

    private UUID stepId;
    private String question;
    private String answer;

    public SubmitAnswerRequest() {
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
}
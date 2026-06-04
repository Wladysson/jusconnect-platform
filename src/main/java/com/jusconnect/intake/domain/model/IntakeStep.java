package com.jusconnect.intake.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IntakeStep {

    private UUID id;
    private UUID intakeId;
    private String title;
    private Integer order;

    private List<IntakeAnswer> answers = new ArrayList<>();

    public IntakeStep() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<IntakeAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<IntakeAnswer> answers) {
        this.answers = answers;
    }
}
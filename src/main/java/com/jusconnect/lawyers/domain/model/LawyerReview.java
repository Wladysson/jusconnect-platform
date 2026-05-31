package com.jusconnect.lawyers.domain.model;

import com.jusconnect.lawyers.domain.enums.ReviewStatus;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.prefs.Preferences;

public class LawyerReview {

    private UUID id;
    private UUID lawyerId;
    private UUID clientId;

    private Integer rating;
    private String comment;

    private LocalDateTime createdAt;

    public LawyerReview() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(UUID lawyerId) {
        this.lawyerId = lawyerId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(ReviewStatus reviewStatus) {

    }

    public Preferences getStatus() {
        return null;
    }
}
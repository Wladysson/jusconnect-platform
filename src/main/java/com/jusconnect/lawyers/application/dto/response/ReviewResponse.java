package com.jusconnect.lawyers.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReviewResponse {

    private UUID id;
    private UUID clientId;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;

    public ReviewResponse() {
    }

    public ReviewResponse(
            UUID id,
            UUID clientId,
            Integer rating,
            String comment,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.clientId = clientId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
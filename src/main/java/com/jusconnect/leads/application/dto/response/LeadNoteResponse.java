package com.jusconnect.leads.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class LeadNoteResponse {

    private UUID id;
    private String note;
    private LocalDateTime createdAt;

    public LeadNoteResponse(
            UUID id,
            String note,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.note = note;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
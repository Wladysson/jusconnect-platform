package com.jusconnect.users.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class DocumentResponse {

    private UUID id;
    private String type;
    private String fileUrl;
    private boolean verified;

    private LocalDateTime createdAt;

    public DocumentResponse() {
    }

    public DocumentResponse(
            UUID id,
            String type,
            String fileUrl,
            boolean verified,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.type = type;
        this.fileUrl = fileUrl;
        this.verified = verified;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public boolean isVerified() {
        return verified;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
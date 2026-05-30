package com.jusconnect.users.domain.model;

import com.jusconnect.users.domain.enums.DocumentType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Document {

    private UUID id;
    private UUID userId;

    private DocumentType type; // CPF, RG, OAB, etc
    private String number;
    private String fileUrl;

    private boolean verified;
    private LocalDateTime createdAt;

    public Document() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(
            UUID userId
    ) {
        this.userId = userId;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(
            DocumentType type
    ) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(
            String number
    ) {
        this.number = number;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(
            String fileUrl
    ) {
        this.fileUrl = fileUrl;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(
            boolean verified
    ) {
        this.verified = verified;
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
package com.jusconnect.intake.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class IntakeDocumentResponse {

    private UUID id;
    private UUID intakeId;
    private String documentType;
    private String fileName;
    private String fileUrl;
    private LocalDateTime uploadedAt;

    public IntakeDocumentResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(
            UUID id
    ) {
        this.id = id;
    }

    public UUID getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(
            UUID intakeId
    ) {
        this.intakeId = intakeId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(
            String documentType
    ) {
        this.documentType = documentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(
            String fileName
    ) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(
            String fileUrl
    ) {
        this.fileUrl = fileUrl;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(
            LocalDateTime uploadedAt
    ) {
        this.uploadedAt = uploadedAt;
    }
}
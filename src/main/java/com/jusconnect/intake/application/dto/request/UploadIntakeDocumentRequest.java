package com.jusconnect.intake.application.dto.request;

import java.util.UUID;

public class UploadIntakeDocumentRequest {

    private UUID intakeId;
    private String documentType;
    private String fileName;
    private String fileUrl;

    public UploadIntakeDocumentRequest() {
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
}
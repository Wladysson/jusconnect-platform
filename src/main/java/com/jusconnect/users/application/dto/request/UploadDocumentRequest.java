package com.jusconnect.users.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.jusconnect.users.domain.enums.DocumentType;

public class UploadDocumentRequest {

    @NotNull
    private DocumentType type;

    @NotBlank
    private String fileUrl;

    public UploadDocumentRequest() {
    }

    public DocumentType getType() {
        return type;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public String getNumber() {
        return "";
    }
}
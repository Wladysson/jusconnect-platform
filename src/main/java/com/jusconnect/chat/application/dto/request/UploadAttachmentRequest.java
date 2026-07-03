package com.jusconnect.chat.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.UUID;

public class UploadAttachmentRequest {

    // Identificador da conversa
    @NotNull(message = "O identificador da conversa é obrigatório.")
    private UUID conversationId;

    // Identificador do usuário que está enviando o anexo
    @NotNull(message = "O identificador do usuário é obrigatório.")
    private UUID senderId;

    // Nome original do arquivo
    @NotBlank(message = "O nome do arquivo é obrigatório.")
    private String fileName;

    // Tipo do arquivo (MIME Type)
    @NotBlank(message = "O tipo do arquivo é obrigatório.")
    private String contentType;

    // Tamanho do arquivo em bytes
    @NotNull(message = "O tamanho do arquivo é obrigatório.")
    @Positive(message = "O tamanho do arquivo deve ser maior que zero.")
    private Long fileSize;

    // Caminho ou identificador do arquivo armazenado
    @NotBlank(message = "O caminho do arquivo é obrigatório.")
    private String storagePath;

    public UploadAttachmentRequest() {
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }
}
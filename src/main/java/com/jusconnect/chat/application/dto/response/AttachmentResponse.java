package com.jusconnect.chat.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class AttachmentResponse {

    // Identificador do anexo
    private UUID id;

    // Identificador da conversa
    private UUID conversationId;

    // Identificador da mensagem
    private UUID messageId;

    // Identificador do usuário que enviou o anexo
    private UUID senderId;

    // Nome original do arquivo
    private String fileName;

    // Tipo do arquivo
    private String contentType;

    // Categoria do anexo
    private String attachmentType;

    // Tamanho do arquivo em bytes
    private Long fileSize;

    // Local onde o arquivo está armazenado
    private String storagePath;

    // URL para acesso ao arquivo
    private String downloadUrl;

    // Data de envio
    private LocalDateTime uploadedAt;

    public AttachmentResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
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

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
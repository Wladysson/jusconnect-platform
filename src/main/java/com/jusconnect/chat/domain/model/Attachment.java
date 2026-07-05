package com.jusconnect.chat.domain.model;

import com.jusconnect.chat.domain.enums.AttachmentType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Attachment {

    // Identificador do anexo
    private UUID id;

    // Identificador da conversa
    private UUID conversationId;

    // Identificador da mensagem
    private UUID messageId;

    // Identificador do remetente
    private UUID senderId;

    // Nome original do arquivo
    private String fileName;

    // Tipo do anexo
    private AttachmentType attachmentType;

    // Tipo MIME do arquivo
    private String contentType;

    // Tamanho do arquivo em bytes
    private Long fileSize;

    // Caminho de armazenamento
    private String storagePath;

    // URL para download
    private String downloadUrl;

    // Data do upload
    private LocalDateTime uploadedAt;

    public Attachment() {
        this.id = UUID.randomUUID();
        this.uploadedAt = LocalDateTime.now();
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

    public AttachmentType getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(AttachmentType attachmentType) {
        this.attachmentType = attachmentType;
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
package com.jusconnect.chat.infrastructure.persistence.entity;

import com.jusconnect.chat.domain.enums.AttachmentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "chat_attachments")
public class AttachmentEntity {

    // Identificador do anexo
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    // Identificador da conversa
    @Column(name = "conversation_id", nullable = false)
    private UUID conversationId;

    // Identificador da mensagem
    @Column(name = "message_id", nullable = false)
    private UUID messageId;

    // Identificador do remetente
    @Column(name = "sender_id", nullable = false)
    private UUID senderId;

    // Nome do arquivo
    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    // Tipo do anexo
    @Enumerated(EnumType.STRING)
    @Column(name = "attachment_type", nullable = false, length = 30)
    private AttachmentType attachmentType;

    // Tipo MIME
    @Column(name = "content_type", nullable = false, length = 100)
    private String contentType;

    // Tamanho do arquivo
    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    // Caminho físico/lógico do arquivo
    @Column(name = "storage_path", nullable = false, length = 500)
    private String storagePath;

    // URL para download
    @Column(name = "download_url", length = 500)
    private String downloadUrl;

    // Data do upload
    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime uploadedAt;

    public AttachmentEntity() {
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
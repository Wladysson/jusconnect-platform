package com.jusconnect.chat.application.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MessageResponse {

    // Identificador da mensagem
    private UUID id;

    // Identificador da conversa
    private UUID conversationId;

    // Identificador do remetente
    private UUID senderId;

    // Nome do remetente
    private String senderName;

    // Conteúdo da mensagem
    private String content;

    // Tipo da mensagem
    private String messageType;

    // Status da mensagem
    private String status;

    // Identificadores dos anexos
    private List<UUID> attachmentIds;

    // Data de envio
    private LocalDateTime sentAt;

    // Data da última atualização
    private LocalDateTime updatedAt;

    public MessageResponse() {
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

    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UUID> getAttachmentIds() {
        return attachmentIds;
    }

    public void setAttachmentIds(List<UUID> attachmentIds) {
        this.attachmentIds = attachmentIds;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
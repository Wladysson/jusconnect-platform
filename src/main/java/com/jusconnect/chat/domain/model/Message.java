package com.jusconnect.chat.domain.model;

import com.jusconnect.chat.domain.enums.MessageStatus;
import com.jusconnect.chat.domain.enums.MessageType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Message {

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
    private MessageType messageType;

    // Status da mensagem
    private MessageStatus status;

    // Lista de anexos
    private List<UUID> attachmentIds = new ArrayList<>();

    // Metadados da mensagem
    private MessageMetadata metadata;

    // Data de envio
    private LocalDateTime sentAt;

    // Data da última atualização
    private LocalDateTime updatedAt;

    public Message() {
        this.id = UUID.randomUUID();
        this.status = MessageStatus.CREATED;
        this.sentAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public List<UUID> getAttachmentIds() {
        return attachmentIds;
    }

    public void setAttachmentIds(List<UUID> attachmentIds) {
        this.attachmentIds = attachmentIds;
    }

    public MessageMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(MessageMetadata metadata) {
        this.metadata = metadata;
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
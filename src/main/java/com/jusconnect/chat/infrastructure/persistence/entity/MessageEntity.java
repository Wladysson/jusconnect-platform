package com.jusconnect.chat.infrastructure.persistence.entity;

import com.jusconnect.chat.domain.enums.MessageStatus;
import com.jusconnect.chat.domain.enums.MessageType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chat_messages")
public class MessageEntity {

    // Identificador da mensagem
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    // Identificador da conversa
    @Column(name = "conversation_id", nullable = false)
    private UUID conversationId;

    // Identificador do remetente
    @Column(name = "sender_id", nullable = false)
    private UUID senderId;

    // Nome do remetente
    @Column(name = "sender_name", length = 150)
    private String senderName;

    // Conteúdo da mensagem
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    // Tipo da mensagem
    @Enumerated(EnumType.STRING)
    @Column(name = "message_type", nullable = false)
    private MessageType messageType;

    // Status da mensagem
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MessageStatus status;

    // Identificadores dos anexos
    @ElementCollection
    @CollectionTable(
            name = "chat_message_attachments",
            joinColumns = @JoinColumn(name = "message_id")
    )
    @Column(name = "attachment_id")
    private List<UUID> attachmentIds = new ArrayList<>();

    // Data de envio
    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    // Data da última atualização
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public MessageEntity() {
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
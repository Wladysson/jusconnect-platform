package com.jusconnect.chat.application.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ConversationResponse {

    // Identificador da conversa
    private UUID id;

    // Nome da conversa
    private String name;

    // Tipo da conversa
    private String conversationType;

    // Status da conversa
    private String status;

    // Identificador do criador da conversa
    private UUID createdBy;

    // Participantes da conversa
    private List<UUID> participantIds;

    // Última mensagem enviada
    private MessageResponse lastMessage;

    // Quantidade de mensagens não lidas
    private Integer unreadMessages;

    // Data de criação
    private LocalDateTime createdAt;

    // Data da última atualização
    private LocalDateTime updatedAt;

    public ConversationResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConversationType() {
        return conversationType;
    }

    public void setConversationType(String conversationType) {
        this.conversationType = conversationType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public List<UUID> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(List<UUID> participantIds) {
        this.participantIds = participantIds;
    }

    public MessageResponse getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(MessageResponse lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Integer getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(Integer unreadMessages) {
        this.unreadMessages = unreadMessages;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
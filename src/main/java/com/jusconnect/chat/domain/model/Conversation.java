package com.jusconnect.chat.domain.model;

import com.jusconnect.chat.domain.enums.ConversationStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conversation {

    // Identificador da conversa
    private ConversationId id;

    // Nome da conversa
    private String name;

    // Tipo da conversa
    private String conversationType;

    // Status da conversa
    private ConversationStatus status;

    // Identificador do criador
    private UUID createdBy;

    // Lista de participantes
    private List<UUID> participantsIds = new ArrayList<>();

    // Última mensagem enviada
    private Message lastMessage;

    // Quantidade de mensagens não lidas
    private Integer unreadMessages;

    // Indica se a conversa está arquivada
    private boolean archived;

    // Configurações da conversa
    private ConversationSettings settings;

    // Data da última atividade
    private LocalDateTime lastActivityAt;

    // Data de criação
    private LocalDateTime createdAt;

    // Data da última atualização
    private LocalDateTime updatedAt;

    public Conversation() {
        this.id = new ConversationId();
        this.status = ConversationStatus.ACTIVE;
        this.unreadMessages = 0;
        this.archived = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.lastActivityAt = LocalDateTime.now();
    }

    public ConversationId getId() {
        return id;
    }

    public void setId(ConversationId id) {
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

    public ConversationStatus getStatus() {
        return status;
    }

    public void setStatus(ConversationStatus status) {
        this.status = status;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public List<UUID> getParticipantsIds() {
        return participantsIds;
    }

    public void setParticipantsIds(List<UUID> participantsIds) {
        this.participantsIds = participantsIds;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Integer getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(Integer unreadMessages) {
        this.unreadMessages = unreadMessages;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public ConversationSettings getSettings() {
        return settings;
    }

    public void setSettings(ConversationSettings settings) {
        this.settings = settings;
    }

    public LocalDateTime getLastActivityAt() {
        return lastActivityAt;
    }

    public void setLastActivityAt(LocalDateTime lastActivityAt) {
        this.lastActivityAt = lastActivityAt;
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
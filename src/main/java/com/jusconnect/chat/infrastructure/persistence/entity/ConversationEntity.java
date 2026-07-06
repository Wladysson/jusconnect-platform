package com.jusconnect.chat.infrastructure.persistence.entity;

import com.jusconnect.chat.domain.enums.ConversationStatus;

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
@Table(name = "chat_conversations")
public class ConversationEntity {

    // Identificador da conversa
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    // Nome da conversa
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    // Tipo da conversa
    @Column(name = "conversation_type", nullable = false, length = 30)
    private String conversationType;

    // Status da conversa
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ConversationStatus status;

    // Usuário criador
    @Column(name = "created_by", nullable = false)
    private UUID createdBy;

    // Participantes da conversa
    @ElementCollection
    @CollectionTable(
            name = "chat_conversation_participants",
            joinColumns = @JoinColumn(name = "conversation_id")
    )
    @Column(name = "participant_id")
    private List<UUID> participantsIds = new ArrayList<>();

    // Quantidade de mensagens não lidas
    @Column(name = "unread_messages")
    private Integer unreadMessages;

    // Indica se a conversa está arquivada
    @Column(name = "archived")
    private boolean archived;

    // Data da última atividade
    @Column(name = "last_activity_at")
    private LocalDateTime lastActivityAt;

    // Data de criação
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Data da última atualização
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ConversationEntity() {
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
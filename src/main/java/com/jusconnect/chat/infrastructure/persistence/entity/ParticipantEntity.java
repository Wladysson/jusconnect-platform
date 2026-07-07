package com.jusconnect.chat.infrastructure.persistence.entity;

import com.jusconnect.chat.domain.enums.ParticipantRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "chat_participants")
public class ParticipantEntity {

    // Identificador do participante
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    // Identificador da conversa
    @Column(name = "conversation_id", nullable = false)
    private UUID conversationId;

    // Identificador do usuário
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    // Papel do participante
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 30)
    private ParticipantRole role;

    // Indica se o participante está ativo
    @Column(name = "active", nullable = false)
    private boolean active;

    // Data de entrada
    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

    // Data da última leitura
    @Column(name = "last_read_at")
    private LocalDateTime lastReadAt;

    public ParticipantEntity() {
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public ParticipantRole getRole() {
        return role;
    }

    public void setRole(ParticipantRole role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    public LocalDateTime getLastReadAt() {
        return lastReadAt;
    }

    public void setLastReadAt(LocalDateTime lastReadAt) {
        this.lastReadAt = lastReadAt;
    }

}
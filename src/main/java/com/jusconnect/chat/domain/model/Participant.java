package com.jusconnect.chat.domain.model;

import com.jusconnect.chat.domain.enums.ParticipantRole;

import java.time.LocalDateTime;
import java.util.UUID;

public class Participant {

    // Identificador do participante
    private UUID id;

    // Identificador da conversa
    private UUID conversationId;

    // Identificador do usuário
    private UUID userId;

    // Papel do participante na conversa
    private ParticipantRole role;

    // Indica se o participante está ativo
    private boolean active;

    // Data de entrada na conversa
    private LocalDateTime joinedAt;

    // Data da última leitura
    private LocalDateTime lastReadAt;

    public Participant() {
        this.id = UUID.randomUUID();
        this.role = ParticipantRole.MEMBER;
        this.active = true;
        this.joinedAt = LocalDateTime.now();
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
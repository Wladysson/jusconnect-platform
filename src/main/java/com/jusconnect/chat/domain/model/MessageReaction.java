package com.jusconnect.chat.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessageReaction {

    // Identificador da reação
    private UUID id;

    // Identificador da mensagem
    private UUID messageId;

    // Identificador do usuário
    private UUID userId;

    // Emoji ou reação aplicada
    private String reaction;

    // Data da reação
    private LocalDateTime reactedAt;

    public MessageReaction() {
        this.id = UUID.randomUUID();
        this.reactedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public LocalDateTime getReactedAt() {
        return reactedAt;
    }

    public void setReactedAt(LocalDateTime reactedAt) {
        this.reactedAt = reactedAt;
    }
}
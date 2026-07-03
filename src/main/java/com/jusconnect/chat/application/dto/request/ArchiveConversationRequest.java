package com.jusconnect.chat.application.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class ArchiveConversationRequest {

    // Identificador da conversa
    @NotNull(message = "O identificador da conversa é obrigatório.")
    private UUID conversationId;

    // Identificador do usuário que está arquivando a conversa
    @NotNull(message = "O identificador do usuário é obrigatório.")
    private UUID userId;

    public ArchiveConversationRequest() {
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
}
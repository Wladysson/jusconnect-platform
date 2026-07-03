package com.jusconnect.chat.application.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class MarkMessageAsReadRequest {

    // Identificador da mensagem
    @NotNull(message = "O identificador da mensagem é obrigatório.")
    private UUID messageId;

    // Identificador do usuário que realizou a leitura
    @NotNull(message = "O identificador do usuário é obrigatório.")
    private UUID userId;

    public MarkMessageAsReadRequest() {
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
}
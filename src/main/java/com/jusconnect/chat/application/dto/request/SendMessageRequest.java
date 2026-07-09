package com.jusconnect.chat.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public class SendMessageRequest {

    // Identificador da conversa
    @NotNull(message = "O identificador da conversa é obrigatório.")
    private UUID conversationId;

    // Identificador do remetente
    @NotNull(message = "O identificador do remetente é obrigatório.")
    private UUID senderId;

    // Conteúdo da mensagem
    @NotBlank(message = "A mensagem não pode estar vazia.")
    @Size(max = 5000, message = "A mensagem deve possuir no máximo 5000 caracteres.")
    private String content;

    // Tipo da mensagem (TEXT, IMAGE, FILE...)
    @NotBlank(message = "O tipo da mensagem é obrigatório.")
    private String messageType;

    // Lista de anexos enviados junto com a mensagem
    private List<UUID> attachmentIds;

    public SendMessageRequest() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public List<UUID> getAttachmentIds() {
        return attachmentIds;
    }

    public void setAttachmentIds(List<UUID> attachmentIds) {
        this.attachmentIds = attachmentIds;
    }
}
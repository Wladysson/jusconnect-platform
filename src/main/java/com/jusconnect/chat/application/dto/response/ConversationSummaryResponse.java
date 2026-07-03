package com.jusconnect.chat.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class ConversationSummaryResponse {

    // Identificador da conversa
    private UUID id;

    // Nome da conversa
    private String name;

    // Última mensagem enviada
    private String lastMessage;

    // Nome do remetente da última mensagem
    private String lastSenderName;

    // Quantidade de mensagens não lidas
    private Integer unreadMessages;

    // Indica se a conversa está arquivada
    private Boolean archived;

    // Data da última atividade da conversa
    private LocalDateTime lastActivityAt;

    public ConversationSummaryResponse() {
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

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastSenderName() {
        return lastSenderName;
    }

    public void setLastSenderName(String lastSenderName) {
        this.lastSenderName = lastSenderName;
    }

    public Integer getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(Integer unreadMessages) {
        this.unreadMessages = unreadMessages;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public LocalDateTime getLastActivityAt() {
        return lastActivityAt;
    }

    public void setLastActivityAt(LocalDateTime lastActivityAt) {
        this.lastActivityAt = lastActivityAt;
    }
}
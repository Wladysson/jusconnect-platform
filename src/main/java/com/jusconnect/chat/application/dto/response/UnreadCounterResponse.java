package com.jusconnect.chat.application.dto.response;

import java.util.UUID;

public class UnreadCounterResponse {

    // Identificador do usuário
    private UUID userId;

    // Quantidade total de mensagens não lidas
    private Integer totalUnreadMessages;

    // Quantidade de conversas com mensagens não lidas
    private Integer unreadConversations;

    public UnreadCounterResponse() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Integer getTotalUnreadMessages() {
        return totalUnreadMessages;
    }

    public void setTotalUnreadMessages(Integer totalUnreadMessages) {
        this.totalUnreadMessages = totalUnreadMessages;
    }

    public Integer getUnreadConversations() {
        return unreadConversations;
    }

    public void setUnreadConversations(Integer unreadConversations) {
        this.unreadConversations = unreadConversations;
    }
}
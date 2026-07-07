package com.jusconnect.chat.infrastructure.websocket;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ChatEventPublisher {

    // Gerenciador das sessões
    @Inject
    ChatSessionManager sessionManager;

    // Publica um evento para um usuário
    public void publish(String userId, String payload) {

        sessionManager.sendMessage(userId, payload);

    }

}
package com.jusconnect.chat.infrastructure.websocket;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChatWebSocket {

    // Gerenciador das sessões WebSocket
    private final ChatSessionManager sessionManager = ChatSessionManager.getInstance();

    // Executado quando uma conexão é aberta
    public void onOpen(Object session, String userId) {

        // Registra a sessão do usuário
        sessionManager.addSession(userId, session);

    }

    // Executado quando uma mensagem é recebida
    public void onMessage(String message, Object session) {

        // Apenas mantém a conexão ativa
        // O processamento será realizado pelos serviços do domínio
    }

    // Executado quando a conexão é encerrada
    public void onClose(Object session, String userId) {

        // Remove a sessão do usuário
        sessionManager.removeSession(userId);

    }

}
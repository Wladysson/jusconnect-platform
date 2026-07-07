package com.jusconnect.chat.infrastructure.websocket;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@ApplicationScoped
@ServerEndpoint("/ws/chat/{userId}")
public class ChatWebSocket {

    // Gerenciador das sessões WebSocket
    private final ChatSessionManager sessionManager = ChatSessionManager.getInstance();

    // Executado quando uma conexão é aberta
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {

        // Registra a sessão do usuário
        sessionManager.addSession(userId, session);

    }

    // Executado quando uma mensagem é recebida
    @OnMessage
    public void onMessage(String message, Session session) {

        // Apenas mantém a conexão ativa
        // O processamento será realizado pelos serviços do domínio
    }

    // Executado quando a conexão é encerrada
    @OnClose
    public void onClose(Session session, @PathParam("userId") String userId) {

        // Remove a sessão do usuário
        sessionManager.removeSession(userId);

    }

}
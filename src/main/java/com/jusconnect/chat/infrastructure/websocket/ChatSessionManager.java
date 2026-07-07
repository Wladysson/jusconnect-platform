package com.jusconnect.chat.infrastructure.websocket;

import jakarta.websocket.Session;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatSessionManager {

    // Instância única
    private static final ChatSessionManager INSTANCE = new ChatSessionManager();

    // Sessões ativas
    private final Map<String, Session> sessions = new ConcurrentHashMap<>();

    private ChatSessionManager() {
    }

    // Obtém a instância
    public static ChatSessionManager getInstance() {
        return INSTANCE;
    }

    // Adiciona uma sessão
    public void addSession(String userId, Session session) {

        sessions.put(userId, session);

    }

    // Remove uma sessão
    public void removeSession(String userId) {

        sessions.remove(userId);

    }

    // Envia mensagem para um usuário
    public void sendMessage(String userId, String message) {

        Session session = sessions.get(userId);

        if (session == null) {
            return;
        }

        if (!session.isOpen()) {
            return;
        }

        try {

            session.getBasicRemote().sendText(message);

        } catch (IOException ignored) {
        }

    }

    // Verifica se o usuário está conectado
    public boolean isConnected(String userId) {

        return sessions.containsKey(userId);

    }

}
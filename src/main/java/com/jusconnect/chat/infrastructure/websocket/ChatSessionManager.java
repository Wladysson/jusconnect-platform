package com.jusconnect.chat.infrastructure.websocket;

import jakarta.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class ChatSessionManager {

    // Instância única
    private static final ChatSessionManager INSTANCE = new ChatSessionManager();

    // Sessões ativas (session is an implementation-specific object)
    private final Map<String, Object> sessions = new ConcurrentHashMap<>();

    private ChatSessionManager() {
    }

    // Obtém a instância
    public static ChatSessionManager getInstance() {
        return INSTANCE;
    }

    // Adiciona uma sessão
    public void addSession(String userId, Object session) {
        if (userId == null || session == null) return;
        sessions.put(userId, session);
    }

    // Remove uma sessão
    public void removeSession(String userId) {
        if (userId == null) return;
        sessions.remove(userId);
    }

    // Envia mensagem para um usuário (usa reflection para evitar dependência direta)
    public void sendMessage(String userId, String message) {
        Object session = sessions.get(userId);
        if (session == null) return;

        try {
            Method isOpen = session.getClass().getMethod("isOpen");
            Boolean open = (Boolean) isOpen.invoke(session);
            if (open == null || !open) return;

            Method getBasicRemote = session.getClass().getMethod("getBasicRemote");
            Object remote = getBasicRemote.invoke(session);
            if (remote == null) return;

            Method sendText = remote.getClass().getMethod("sendText", String.class);
            sendText.invoke(remote, message);
        } catch (Exception ignored) {
            // If reflection fails, swallow to keep manager safe; logging may be added later
        }
    }

    // Verifica se o usuário está conectado
    public boolean isConnected(String userId) {
        return sessions.containsKey(userId);
    }

}

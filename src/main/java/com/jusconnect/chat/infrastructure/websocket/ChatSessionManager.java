package com.jusconnect.chat.infrastructure.websocket;

import jakarta.websocket.Session;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatSessionManager {

    private static final ChatSessionManager INSTANCE = new ChatSessionManager();

    private final Map<String, Session> sessions = new ConcurrentHashMap<>();

    private ChatSessionManager() {
    }

    public static ChatSessionManager getInstance() {
        return INSTANCE;
    }

    public void addSession(String userId, Session session) {
        if (userId == null || session == null) return;
        sessions.put(userId, session);
    }

    public void removeSession(String userId) {
        if (userId == null) return;
        sessions.remove(userId);
    }

    public Session getSession(String userId) {
        return userId == null ? null : sessions.get(userId);
    }

    public void sendToUser(String userId, String message) {
        Session session = getSession(userId);
        if (session != null && session.isOpen()) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                // swallow - manager should not throw; logging may be added later
            }
        }
    }
}

package com.jusconnect.chat.domain.repository;

import com.jusconnect.chat.domain.model.Message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageRepository {

    // Salva uma mensagem
    Message save(Message message);

    // Atualiza uma mensagem
    Message update(Message message);

    // Busca uma mensagem pelo identificador
    Optional<Message> findById(UUID messageId);

    // Lista as mensagens de uma conversa
    List<Message> findByConversationId(UUID conversationId);

    // Lista as mensagens não lidas de um usuário
    List<Message> findUnreadMessages(UUID userId);

    // Remove uma mensagem
    void delete(UUID messageId);

    // Verifica se uma mensagem existe
    boolean existsById(UUID messageId);

    // Conta as mensagens não lidas de um usuário
    Integer countUnreadByUserId(UUID userId);

}
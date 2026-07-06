package com.jusconnect.chat.domain.repository;

import com.jusconnect.chat.domain.model.Conversation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConversationRepository {

    // Salva uma conversa
    Conversation save(Conversation conversation);

    // Atualiza uma conversa
    Conversation update(Conversation conversation);

    // Busca uma conversa pelo identificador
    Optional<Conversation> findById(UUID conversationId);

    // Lista todas as conversas de um usuário
    List<Conversation> findByUserId(UUID userId);

    // Pesquisa conversas utilizando um termo
    List<Conversation> search(UUID userId, String searchTerm);

    // Verifica se uma conversa existe
    boolean existsById(UUID conversationId);

    // Remove uma conversa
    void delete(UUID conversationId);

    // Conta as conversas com mensagens não lidas de um usuário
    Integer countUnreadByUserId(UUID userId);

}
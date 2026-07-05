package com.jusconnect.chat.domain.service;

import com.jusconnect.chat.domain.model.Conversation;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConversationValidationService {

    // Valida a criação da conversa
    public void validateCreation(Conversation conversation) {

        if (conversation.getName() == null || conversation.getName().isBlank()) {
            throw new IllegalArgumentException("O nome da conversa é obrigatório.");
        }

        if (conversation.getParticipantsIds() == null
                || conversation.getParticipantsIds().isEmpty()) {
            throw new IllegalArgumentException("A conversa deve possuir participantes.");
        }

    }

    // Verifica se a conversa pode receber mensagens
    public void validateCanReceiveMessages(Conversation conversation) {

        if (conversation.isArchived()) {
            throw new IllegalStateException("A conversa está arquivada.");
        }

    }

}
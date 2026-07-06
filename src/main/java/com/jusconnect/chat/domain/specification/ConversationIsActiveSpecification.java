package com.jusconnect.chat.domain.specification;

import com.jusconnect.chat.domain.enums.ConversationStatus;
import com.jusconnect.chat.domain.model.Conversation;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConversationIsActiveSpecification {

    // Verifica se a conversa está ativa
    public boolean isSatisfiedBy(Conversation conversation) {

        if (conversation == null) {
            return false;
        }

        return ConversationStatus.ACTIVE.equals(conversation.getStatus());
    }

}
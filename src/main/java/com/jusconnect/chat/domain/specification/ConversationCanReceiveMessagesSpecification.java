package com.jusconnect.chat.domain.specification;

import com.jusconnect.chat.domain.enums.ConversationStatus;
import com.jusconnect.chat.domain.model.Conversation;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConversationCanReceiveMessagesSpecification {

    // Verifica se a conversa pode receber mensagens
    public boolean isSatisfiedBy(Conversation conversation) {

        if (conversation == null) {
            return false;
        }

        if (conversation.isArchived()) {
            return false;
        }

        return ConversationStatus.ACTIVE.equals(conversation.getStatus());
    }

}
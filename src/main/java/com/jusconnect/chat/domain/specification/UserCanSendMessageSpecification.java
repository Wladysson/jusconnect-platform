package com.jusconnect.chat.domain.specification;

import com.jusconnect.chat.domain.model.Conversation;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class UserCanSendMessageSpecification {

    // Verifica se o usuário pertence à conversa
    public boolean isSatisfiedBy(Conversation conversation, UUID userId) {

        if (conversation == null || userId == null) {
            return false;
        }

        return conversation.getParticipantsIds().contains(userId);
    }

}
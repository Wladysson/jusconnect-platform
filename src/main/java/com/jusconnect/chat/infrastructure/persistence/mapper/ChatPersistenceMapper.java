package com.jusconnect.chat.infrastructure.persistence.mapper;

import com.jusconnect.chat.domain.model.Conversation;
import com.jusconnect.chat.domain.model.ConversationId;
import com.jusconnect.chat.domain.model.Message;
import com.jusconnect.chat.infrastructure.persistence.entity.ConversationEntity;
import com.jusconnect.chat.infrastructure.persistence.entity.MessageEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChatPersistenceMapper {

    // Converte entidade JPA para domínio
    public Conversation toDomain(ConversationEntity entity) {

        if (entity == null) {
            return null;
        }

        Conversation conversation = new Conversation();

        conversation.setId(new ConversationId(entity.getId()));
        conversation.setName(entity.getName());
        conversation.setConversationType(entity.getConversationType());
        conversation.setStatus(entity.getStatus());
        conversation.setCreatedBy(entity.getCreatedBy());
        conversation.setParticipantsIds(entity.getParticipantsIds());
        conversation.setUnreadMessages(entity.getUnreadMessages());
        conversation.setArchived(entity.isArchived());
        conversation.setLastActivityAt(entity.getLastActivityAt());
        conversation.setCreatedAt(entity.getCreatedAt());
        conversation.setUpdatedAt(entity.getUpdatedAt());

        return conversation;
    }

    // Converte domínio para entidade JPA
    public ConversationEntity toEntity(Conversation conversation) {

        if (conversation == null) {
            return null;
        }

        ConversationEntity entity = new ConversationEntity();

        entity.setId(conversation.getId().getValue());
        entity.setName(conversation.getName());
        entity.setConversationType(conversation.getConversationType());
        entity.setStatus(conversation.getStatus());
        entity.setCreatedBy(conversation.getCreatedBy());
        entity.setParticipantsIds(conversation.getParticipantsIds());
        entity.setUnreadMessages(conversation.getUnreadMessages());
        entity.setArchived(conversation.isArchived());
        entity.setLastActivityAt(conversation.getLastActivityAt());
        entity.setCreatedAt(conversation.getCreatedAt());
        entity.setUpdatedAt(conversation.getUpdatedAt());

        return entity;
    }

    // Converte entidade JPA para domínio
    public Message toDomain(MessageEntity entity) {

        if (entity == null) {
            return null;
        }

        Message message = new Message();

        message.setId(entity.getId());
        message.setConversationId(entity.getConversationId());
        message.setSenderId(entity.getSenderId());
        message.setSenderName(entity.getSenderName());
        message.setContent(entity.getContent());
        message.setMessageType(entity.getMessageType());
        message.setStatus(entity.getStatus());
        message.setAttachmentIds(entity.getAttachmentIds());
        message.setSentAt(entity.getSentAt());
        message.setUpdatedAt(entity.getUpdatedAt());

        return message;
    }

    // Converte domínio para entidade JPA
    public MessageEntity toEntity(Message message) {

        if (message == null) {
            return null;
        }

        MessageEntity entity = new MessageEntity();

        entity.setId(message.getId());
        entity.setConversationId(message.getConversationId());
        entity.setSenderId(message.getSenderId());
        entity.setSenderName(message.getSenderName());
        entity.setContent(message.getContent());
        entity.setMessageType(message.getMessageType());
        entity.setStatus(message.getStatus());
        entity.setAttachmentIds(message.getAttachmentIds());
        entity.setSentAt(message.getSentAt());
        entity.setUpdatedAt(message.getUpdatedAt());

        return entity;
    }

}
package com.jusconnect.chat.application.mapper;

import com.jusconnect.chat.application.dto.response.AttachmentResponse;
import com.jusconnect.chat.application.dto.response.ConversationResponse;
import com.jusconnect.chat.application.dto.response.ConversationSummaryResponse;
import com.jusconnect.chat.application.dto.response.MessageResponse;
import com.jusconnect.chat.application.dto.response.UnreadCounterResponse;
import com.jusconnect.chat.domain.model.Attachment;
import com.jusconnect.chat.domain.model.Conversation;
import com.jusconnect.chat.domain.model.Message;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collections;
import java.util.stream.Collectors;

@ApplicationScoped
public class ChatApplicationMapper {

    // Converte Message para MessageResponse
    public MessageResponse toMessageResponse(Message message) {

        if (message == null) {
            return null;
        }

        MessageResponse response = new MessageResponse();

        response.setId(message.getId());
        response.setConversationId(message.getConversationId());
        response.setSenderId(message.getSenderId());
        response.setSenderName(message.getSenderName());
        response.setContent(message.getContent());
        response.setMessageType(message.getMessageType().name());
        response.setStatus(message.getStatus().name());
        response.setSentAt(message.getSentAt());
        response.setUpdatedAt(message.getUpdatedAt());

        if (message.getAttachmentIds() != null) {
            response.setAttachmentIds(message.getAttachmentIds());
        } else {
            response.setAttachmentIds(Collections.emptyList());
        }

        return response;
    }

    // Converte Conversation para ConversationResponse
    public ConversationResponse toConversationResponse(Conversation conversation) {

        if (conversation == null) {
            return null;
        }

        ConversationResponse response = new ConversationResponse();

        response.setId(conversation.getId().getValue());
        response.setName(conversation.getName());
        response.setConversationType(conversation.getConversationType());
        response.setStatus(conversation.getStatus().name());
        response.setCreatedBy(conversation.getCreatedBy());
        response.setParticipantIds(conversation.getParticipantsIds());
        response.setUnreadMessages(conversation.getUnreadMessages());
        response.setCreatedAt(conversation.getCreatedAt());
        response.setUpdatedAt(conversation.getUpdatedAt());
        response.setLastMessage(toMessageResponse(conversation.getLastMessage()));

        return response;
    }

    // Converte Conversation para resposta resumida
    public ConversationSummaryResponse toConversationSummaryResponse(Conversation conversation) {

        if (conversation == null) {
            return null;
        }

        ConversationSummaryResponse response = new ConversationSummaryResponse();

        response.setId(conversation.getId().getValue());
        response.setName(conversation.getName());
        response.setUnreadMessages(conversation.getUnreadMessages());
        response.setArchived(conversation.isArchived());
        response.setLastActivityAt(conversation.getLastActivityAt());

        if (conversation.getLastMessage() != null) {
            response.setLastMessage(conversation.getLastMessage().getContent());
            response.setLastSenderName(conversation.getLastMessage().getSenderName());
        }

        return response;
    }

    // Converte Attachment para AttachmentResponse
    public AttachmentResponse toAttachmentResponse(Attachment attachment) {

        if (attachment == null) {
            return null;
        }

        AttachmentResponse response = new AttachmentResponse();

        response.setId(attachment.getId());
        response.setConversationId(attachment.getConversationId());
        response.setMessageId(attachment.getMessageId());
        response.setSenderId(attachment.getSenderId());
        response.setFileName(attachment.getFileName());
        response.setContentType(attachment.getContentType());
        response.setAttachmentType(attachment.getAttachmentType().name());
        response.setFileSize(attachment.getFileSize());
        response.setStoragePath(attachment.getStoragePath());
        response.setDownloadUrl(attachment.getDownloadUrl());
        response.setUploadedAt(attachment.getUploadedAt());

        return response;
    }

    // Cria a resposta do contador de mensagens não lidas
    public UnreadCounterResponse toUnreadCounterResponse(
            java.util.UUID userId,
            Integer unreadMessages,
            Integer unreadConversations) {

        UnreadCounterResponse response = new UnreadCounterResponse();

        response.setUserId(userId);
        response.setTotalUnreadMessages(unreadMessages);
        response.setUnreadConversations(unreadConversations);

        return response;
    }
}
package com.jusconnect.chat.domain.service;

import com.jusconnect.chat.application.dto.request.ArchiveConversationRequest;
import com.jusconnect.chat.application.dto.request.CreateConversationRequest;
import com.jusconnect.chat.application.dto.request.MarkMessageAsReadRequest;
import com.jusconnect.chat.application.dto.request.SearchConversationRequest;
import com.jusconnect.chat.application.dto.request.SendMessageRequest;
import com.jusconnect.chat.application.dto.request.UploadAttachmentRequest;
import com.jusconnect.chat.domain.model.Attachment;
import com.jusconnect.chat.domain.model.Conversation;
import com.jusconnect.chat.domain.model.Message;
import com.jusconnect.chat.domain.repository.ConversationRepository;
import com.jusconnect.chat.domain.repository.MessageRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ChatDomainService {

    // Repositório de conversas
    @Inject
    ConversationRepository conversationRepository;

    // Repositório de mensagens
    @Inject
    MessageRepository messageRepository;

    // Serviço de validação de conversas
    @Inject
    ConversationValidationService conversationValidationService;

    // Serviço de entrega de mensagens
    @Inject
    MessageDeliveryService messageDeliveryService;

    // Serviço de validação de anexos
    @Inject
    AttachmentValidationService attachmentValidationService;

    // Cria uma conversa
    public Conversation createConversation(CreateConversationRequest request) {

        Conversation conversation = new Conversation();

        conversation.setName(request.getName());
        conversation.setConversationType(request.getConversationType());
        conversation.setCreatedBy(request.getCreatedBy());
        conversation.setParticipantsIds(request.getParticipantIds());

        conversationValidationService.validateCreation(conversation);

        return conversationRepository.save(conversation);
    }

    // Envia uma mensagem
    public Message sendMessage(SendMessageRequest request) {

        Message message = new Message();

        message.setConversationId(request.getConversationId());
        message.setSenderId(request.getSenderId());
        message.setContent(request.getContent());

        messageDeliveryService.deliver(message);

        return messageRepository.save(message);
    }

    // Busca uma conversa
    public Conversation getConversation(UUID conversationId) {

        return conversationRepository.findById(conversationId)
                .orElseThrow(() -> new IllegalArgumentException("Conversa não encontrada."));
    }

    // Pesquisa conversas
    public List<Conversation> searchConversations(SearchConversationRequest request) {

        return conversationRepository.search(
                request.getUserId(),
                request.getSearchTerm()
        );
    }

    // Marca mensagem como lida
    public void markMessageAsRead(MarkMessageAsReadRequest request) {

        Message message = messageRepository.findById(request.getMessageId())
                .orElseThrow(() -> new IllegalArgumentException("Mensagem não encontrada."));

        messageDeliveryService.markAsRead(message, request.getUserId());

        messageRepository.update(message);
    }

    // Arquiva uma conversa
    public void archiveConversation(ArchiveConversationRequest request) {

        Conversation conversation = getConversation(request.getConversationId());

        conversation.setArchived(true);

        conversationRepository.update(conversation);
    }

    // Processa upload do anexo
    public Attachment uploadAttachment(UploadAttachmentRequest request) {

        Attachment attachment = new Attachment();

        attachment.setConversationId(request.getConversationId());
        attachment.setSenderId(request.getSenderId());
        attachment.setFileName(request.getFileName());
        attachment.setContentType(request.getContentType());
        attachment.setFileSize(request.getFileSize());
        attachment.setStoragePath(request.getStoragePath());

        attachmentValidationService.validate(attachment);

        return attachment;
    }

    // Remove uma mensagem
    public void deleteMessage(UUID messageId) {

        messageRepository.delete(messageId);
    }

}
package com.jusconnect.chat.application.service;

import com.jusconnect.chat.application.dto.request.ArchiveConversationRequest;
import com.jusconnect.chat.application.dto.request.CreateConversationRequest;
import com.jusconnect.chat.application.dto.request.MarkMessageAsReadRequest;
import com.jusconnect.chat.application.dto.request.SearchConversationRequest;
import com.jusconnect.chat.application.dto.request.SendMessageRequest;
import com.jusconnect.chat.application.dto.request.UploadAttachmentRequest;
import com.jusconnect.chat.application.dto.response.AttachmentResponse;
import com.jusconnect.chat.application.dto.response.ConversationResponse;
import com.jusconnect.chat.application.dto.response.ConversationSummaryResponse;
import com.jusconnect.chat.application.dto.response.MessageResponse;
import com.jusconnect.chat.application.dto.response.UnreadCounterResponse;
import com.jusconnect.chat.application.usecase.ArchiveConversationUseCase;
import com.jusconnect.chat.application.usecase.CreateConversationUseCase;
import com.jusconnect.chat.application.usecase.DeleteMessageUseCase;
import com.jusconnect.chat.application.usecase.GetConversationHistoryUseCase;
import com.jusconnect.chat.application.usecase.GetConversationUseCase;
import com.jusconnect.chat.application.usecase.GetUnreadMessagesUseCase;
import com.jusconnect.chat.application.usecase.MarkMessageAsReadUseCase;
import com.jusconnect.chat.application.usecase.SearchConversationsUseCase;
import com.jusconnect.chat.application.usecase.SendMessageUseCase;
import com.jusconnect.chat.application.usecase.UploadAttachmentUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ChatApplicationService {

    // Caso de uso para criar conversas
    @Inject
    CreateConversationUseCase createConversationUseCase;

    // Caso de uso para envio de mensagens
    @Inject
    SendMessageUseCase sendMessageUseCase;

    // Caso de uso para consulta de conversa
    @Inject
    GetConversationUseCase getConversationUseCase;

    // Caso de uso para pesquisa de conversas
    @Inject
    SearchConversationsUseCase searchConversationsUseCase;

    // Caso de uso para marcar mensagem como lida
    @Inject
    MarkMessageAsReadUseCase markMessageAsReadUseCase;

    // Caso de uso para arquivar conversa
    @Inject
    ArchiveConversationUseCase archiveConversationUseCase;

    // Caso de uso para upload de anexos
    @Inject
    UploadAttachmentUseCase uploadAttachmentUseCase;

    // Caso de uso para exclusão de mensagens
    @Inject
    DeleteMessageUseCase deleteMessageUseCase;

    // Caso de uso para mensagens não lidas
    @Inject
    GetUnreadMessagesUseCase getUnreadMessagesUseCase;

    // Caso de uso para histórico da conversa
    @Inject
    GetConversationHistoryUseCase getConversationHistoryUseCase;

    // Cria uma nova conversa
    public ConversationResponse createConversation(CreateConversationRequest request) {
        return createConversationUseCase.execute(request);
    }

    // Envia uma mensagem
    public MessageResponse sendMessage(SendMessageRequest request) {
        return sendMessageUseCase.execute(request);
    }

    // Consulta uma conversa
    public ConversationResponse getConversation(UUID conversationId) {
        return getConversationUseCase.execute(conversationId);
    }

    // Pesquisa conversas
    public List<ConversationSummaryResponse> searchConversations(SearchConversationRequest request) {
        return searchConversationsUseCase.execute(request);
    }

    // Marca mensagem como lida
    public void markMessageAsRead(MarkMessageAsReadRequest request) {
        markMessageAsReadUseCase.execute(request);
    }

    // Arquiva uma conversa
    public void archiveConversation(ArchiveConversationRequest request) {
        archiveConversationUseCase.execute(request);
    }

    // Realiza upload de um anexo
    public AttachmentResponse uploadAttachment(UploadAttachmentRequest request) {
        return uploadAttachmentUseCase.execute(request);
    }

    // Remove uma mensagem
    public void deleteMessage(UUID messageId) {
        deleteMessageUseCase.execute(messageId);
    }

    // Retorna contador de mensagens não lidas
    public UnreadCounterResponse getUnreadMessages(UUID userId) {
        return getUnreadMessagesUseCase.execute(userId);
    }

    // Retorna o histórico da conversa
    public List<MessageResponse> getConversationHistory(UUID conversationId) {
        return getConversationHistoryUseCase.execute(conversationId);
    }
}
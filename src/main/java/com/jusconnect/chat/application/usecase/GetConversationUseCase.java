package com.jusconnect.chat.application.usecase;

import com.jusconnect.chat.application.dto.response.ConversationResponse;
import com.jusconnect.chat.application.mapper.ChatApplicationMapper;
import com.jusconnect.chat.domain.model.Conversation;
import com.jusconnect.chat.domain.service.ChatDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class GetConversationUseCase {

    // Serviço de domínio responsável pelas regras de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Mapper da camada de aplicação
    @Inject
    ChatApplicationMapper mapper;

    // Busca uma conversa pelo identificador
    public ConversationResponse execute(UUID conversationId) {

        // Obtém a conversa no domínio
        Conversation conversation = chatDomainService.getConversation(conversationId);

        // Converte para DTO de resposta
        return mapper.toConversationResponse(conversation);
    }

}
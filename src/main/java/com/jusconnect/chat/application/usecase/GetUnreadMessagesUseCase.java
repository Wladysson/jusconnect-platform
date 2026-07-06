package com.jusconnect.chat.application.usecase;

import com.jusconnect.chat.application.dto.response.UnreadCounterResponse;
import com.jusconnect.chat.application.mapper.ChatApplicationMapper;
import com.jusconnect.chat.domain.service.ChatDomainService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class GetUnreadMessagesUseCase {

    // Serviço de domínio responsável pelas regras de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Mapper da camada de aplicação
    @Inject
    ChatApplicationMapper mapper;

    // Obtém o contador de mensagens não lidas
    public UnreadCounterResponse execute(UUID userId) {

        // Obtém a quantidade de mensagens não lidas
        Integer unreadMessages = chatDomainService.getUnreadMessages(userId);

        // Obtém a quantidade de conversas com mensagens não lidas
        Integer unreadConversations = chatDomainService.getUnreadConversations(userId);

        // Converte para DTO de resposta
        return mapper.toUnreadCounterResponse(
                userId,
                unreadMessages,
                unreadConversations
        );
    }

}
package com.jusconnect.chat.application.usecase;

import com.jusconnect.chat.application.dto.response.MessageResponse;
import com.jusconnect.chat.application.mapper.ChatApplicationMapper;
import com.jusconnect.chat.domain.model.Message;
import com.jusconnect.chat.domain.service.ChatDomainService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GetConversationHistoryUseCase {

    // Serviço de domínio responsável pelas regras de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Mapper da camada de aplicação
    @Inject
    ChatApplicationMapper mapper;

    // Obtém o histórico da conversa
    public List<MessageResponse> execute(UUID conversationId) {

        // Busca as mensagens da conversa
        List<Message> messages = chatDomainService.getConversationHistory(conversationId);

        // Converte para DTO de resposta
        return messages.stream()
                .map(mapper::toMessageResponse)
                .toList();
    }

}
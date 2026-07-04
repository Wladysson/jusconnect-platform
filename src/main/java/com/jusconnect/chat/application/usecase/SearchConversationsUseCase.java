package com.jusconnect.chat.application.usecase;

import com.jusconnect.chat.application.dto.request.SearchConversationRequest;
import com.jusconnect.chat.application.dto.response.ConversationSummaryResponse;
import com.jusconnect.chat.application.mapper.ChatApplicationMapper;
import com.jusconnect.chat.domain.model.Conversation;
import com.jusconnect.chat.domain.service.ChatDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class SearchConversationsUseCase {

    // Serviço de domínio responsável pelas regras de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Mapper da camada de aplicação
    @Inject
    ChatApplicationMapper mapper;

    // Pesquisa conversas utilizando os filtros informados
    public List<ConversationSummaryResponse> execute(SearchConversationRequest request) {

        // Obtém as conversas filtradas
        List<Conversation> conversations = chatDomainService.searchConversations(request);

        // Converte para DTO de resposta
        return conversations.stream()
                .map(mapper::toConversationSummaryResponse)
                .toList();
    }

}
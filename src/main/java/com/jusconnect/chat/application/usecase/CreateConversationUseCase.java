package com.jusconnect.chat.application.usecase;
import com.jusconnect.chat.application.dto.request.CreateConversationRequest;
import com.jusconnect.chat.application.dto.response.ConversationResponse;
import com.jusconnect.chat.application.mapper.ChatApplicationMapper;
import com.jusconnect.chat.domain.model.Conversation;
import com.jusconnect.chat.domain.service.ChatDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreateConversationUseCase {

    // Serviço de domínio responsável pela regra de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Mapper da camada de aplicação
    @Inject
    ChatApplicationMapper mapper;

    // Executa a criação da conversa
    public ConversationResponse execute(CreateConversationRequest request) {

        // Cria a conversa no domínio
        Conversation conversation = chatDomainService.createConversation(request);

        // Converte para DTO de resposta
        return mapper.toConversationResponse(conversation);
    }

}
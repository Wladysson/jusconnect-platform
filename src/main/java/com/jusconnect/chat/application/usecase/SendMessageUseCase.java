package com.jusconnect.chat.application.usecase;

import com.jusconnect.chat.application.dto.request.SendMessageRequest;
import com.jusconnect.chat.application.dto.response.MessageResponse;
import com.jusconnect.chat.application.mapper.ChatApplicationMapper;
import com.jusconnect.chat.domain.model.Message;
import com.jusconnect.chat.domain.service.ChatDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SendMessageUseCase {

    // Serviço de domínio responsável pela regra de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Mapper da camada de aplicação
    @Inject
    ChatApplicationMapper mapper;

    // Executa o envio da mensagem
    public MessageResponse execute(SendMessageRequest request) {

        // Envia a mensagem no domínio
        Message message = chatDomainService.sendMessage(request);

        // Converte para DTO de resposta
        return mapper.toMessageResponse(message);
    }

}
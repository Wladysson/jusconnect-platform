package com.jusconnect.chat.application.usecase;

import com.jusconnect.chat.application.dto.request.MarkMessageAsReadRequest;
import com.jusconnect.chat.domain.service.ChatDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MarkMessageAsReadUseCase {

    // Serviço de domínio responsável pelas regras de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Marca uma mensagem como lida
    public void execute(MarkMessageAsReadRequest request) {

        // Executa a operação no domínio
        chatDomainService.markMessageAsRead(request);
    }

}
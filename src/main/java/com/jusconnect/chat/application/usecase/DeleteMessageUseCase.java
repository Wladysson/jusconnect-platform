package com.jusconnect.chat.application.usecase;

import com.jusconnect.chat.domain.service.ChatDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class DeleteMessageUseCase {

    // Serviço de domínio responsável pelas regras de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Remove uma mensagem
    public void execute(UUID messageId) {

        // Executa a exclusão no domínio
        chatDomainService.deleteMessage(messageId);
    }

}
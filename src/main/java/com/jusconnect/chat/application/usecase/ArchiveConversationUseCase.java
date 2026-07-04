package com.jusconnect.chat.application.usecase;

import com.jusconnect.chat.application.dto.request.ArchiveConversationRequest;
import com.jusconnect.chat.domain.service.ChatDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ArchiveConversationUseCase {

    // Serviço de domínio responsável pelas regras de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Arquiva uma conversa
    public void execute(ArchiveConversationRequest request) {

        // Executa a operação no domínio
        chatDomainService.archiveConversation(request);
    }

}
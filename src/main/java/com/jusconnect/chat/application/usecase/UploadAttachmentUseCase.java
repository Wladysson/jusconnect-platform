package com.jusconnect.chat.application.usecase;

import com.jusconnect.chat.application.dto.request.UploadAttachmentRequest;
import com.jusconnect.chat.application.dto.response.AttachmentResponse;
import com.jusconnect.chat.application.mapper.ChatApplicationMapper;
import com.jusconnect.chat.domain.model.Attachment;
import com.jusconnect.chat.domain.service.ChatDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UploadAttachmentUseCase {

    // Serviço de domínio responsável pelas regras de negócio
    @Inject
    ChatDomainService chatDomainService;

    // Mapper da camada de aplicação
    @Inject
    ChatApplicationMapper mapper;

    // Realiza o upload de um anexo
    public AttachmentResponse execute(UploadAttachmentRequest request) {

        // Processa o anexo no domínio
        Attachment attachment = chatDomainService.uploadAttachment(request);

        // Converte para DTO de resposta
        return mapper.toAttachmentResponse(attachment);
    }

}
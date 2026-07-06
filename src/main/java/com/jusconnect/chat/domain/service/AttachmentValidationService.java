package com.jusconnect.chat.domain.service;

import com.jusconnect.chat.domain.model.Attachment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AttachmentValidationService {

    // Valida um anexo
    public void validate(Attachment attachment) {

        if (attachment.getFileName() == null || attachment.getFileName().isBlank()) {
            throw new IllegalArgumentException("Nome do arquivo obrigatório.");
        }

        if (attachment.getFileSize() == null || attachment.getFileSize() <= 0) {
            throw new IllegalArgumentException("Tamanho do arquivo inválido.");
        }

        if (attachment.getContentType() == null || attachment.getContentType().isBlank()) {
            throw new IllegalArgumentException("Tipo do arquivo obrigatório.");
        }

    }

}
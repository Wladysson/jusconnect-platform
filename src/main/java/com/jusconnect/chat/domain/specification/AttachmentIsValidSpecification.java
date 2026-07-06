package com.jusconnect.chat.domain.specification;

import com.jusconnect.chat.domain.model.Attachment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AttachmentIsValidSpecification {

    // Verifica se o anexo é válido
    public boolean isSatisfiedBy(Attachment attachment) {

        if (attachment == null) {
            return false;
        }

        if (attachment.getFileName() == null || attachment.getFileName().isBlank()) {
            return false;
        }

        if (attachment.getContentType() == null || attachment.getContentType().isBlank()) {
            return false;
        }

        if (attachment.getFileSize() == null || attachment.getFileSize() <= 0) {
            return false;
        }

        return attachment.getStoragePath() != null
                && !attachment.getStoragePath().isBlank();
    }

}
package com.jusconnect.users.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.users.application.dto.request.UploadDocumentRequest;
import com.jusconnect.users.domain.model.Document;
import com.jusconnect.users.domain.enums.DocumentType;
import com.jusconnect.users.domain.repository.DocumentRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class UploadDocumentUseCase {

    @Inject
    DocumentRepository documentRepository;

    public Document execute(
            UUID userId,
            UploadDocumentRequest request
    ) {

        Document document =
                new Document();

        document.setId(
                UUID.randomUUID()
        );

        document.setUserId(
                userId
        );

        document.setType(
                request.getType()
        );

        document.setNumber(
                request.getNumber()
        );

        document.setFileUrl(
                request.getFileUrl()
        );

        document.setVerified(
                false
        );

        document.setCreatedAt(
                LocalDateTime.now()
        );

        documentRepository.save(
                document
        );

        return document;
    }
}
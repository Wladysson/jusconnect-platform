package com.jusconnect.intake.application.usecase;

import com.jusconnect.intake.application.dto.request.UploadIntakeDocumentRequest;
import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.model.IntakeDocument;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class UploadDocumentUseCase {

    @Inject
    IntakeRepository intakeRepository;

    @Transactional
    public IntakeDocument execute(
            UUID intakeId,
            UploadIntakeDocumentRequest request
    ) {

        Intake intake = intakeRepository.findById(
                intakeId
        );

        if (intake == null) {
            throw new IllegalArgumentException(
                    "Intake não encontrado"
            );
        }

        IntakeDocument document = new IntakeDocument();

        document.setId(
                UUID.randomUUID()
        );

        document.setFileName(
                request.getFileName()
        );

        document.setFileUrl(
                request.getFileUrl()
        );

        document.setContentType(
                request.getContentType()
        );

        document.setUploadedAt(
                LocalDateTime.now()
        );

        intake.getDocuments().add(
                document
        );

        intakeRepository.update(
                intake
        );

        return document;
    }
}
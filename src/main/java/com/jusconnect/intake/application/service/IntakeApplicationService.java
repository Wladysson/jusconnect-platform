package com.jusconnect.intake.application.service;

import com.jusconnect.intake.application.dto.request.CreateIntakeRequest;
import com.jusconnect.intake.application.dto.request.SubmitAnswerRequest;
import com.jusconnect.intake.application.dto.request.UpdateIntakeRequest;
import com.jusconnect.intake.application.dto.request.UploadIntakeDocumentRequest;
import com.jusconnect.intake.application.dto.response.IntakeAnswerResponse;
import com.jusconnect.intake.application.dto.response.IntakeDocumentResponse;
import com.jusconnect.intake.application.dto.response.IntakeResponse;
import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class IntakeApplicationService {

    @Inject
    IntakeRepository intakeRepository;

    public Intake create(CreateIntakeRequest request) {
        Intake intake = Intake.from(request);
        return intakeRepository.save(intake);
    }

    public Intake update(
            Intake intake
    ) {
        return intakeRepository.save(intake);
    }

    public Optional<Intake> findById(
            UUID intakeId
    ) {
        return intakeRepository.findById(intakeId);
    }

    public List<Intake> findAll() {
        return intakeRepository.findAllIntakes();
    }

    public void delete(
            UUID intakeId
    ) {
        intakeRepository.delete(intakeId);
    }

    public IntakeDocumentResponse uploadDocument(UUID intakeId, UploadIntakeDocumentRequest request) {
        return null;
    }

    public List<IntakeDocumentResponse> findDocuments(UUID intakeId) {
        return List.of();
    }

    public void deleteDocument(UUID intakeId, UUID documentId) {
    }

    public IntakeAnswerResponse submitAnswer(UUID intakeId, SubmitAnswerRequest request) {
        return null;
    }

    public List<IntakeAnswerResponse> findAnswers(UUID intakeId) {
        return List.of();
    }

    public IntakeResponse update(UUID id, UpdateIntakeRequest request) {
        return null;
    }
}
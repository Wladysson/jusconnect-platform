package com.jusconnect.intake.application.usecase;

import com.jusconnect.intake.application.dto.request.SubmitAnswerRequest;
import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.domain.model.IntakeAnswer;
import com.jusconnect.intake.domain.repository.IntakeAnswerRepository;
import com.jusconnect.intake.domain.repository.IntakeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class SubmitAnswerUseCase {

    @Inject
    IntakeRepository intakeRepository;

    @Inject
    IntakeAnswerRepository answerRepository;

    @Transactional
    public IntakeAnswer execute(
            UUID intakeId,
            SubmitAnswerRequest request
    ) {

        Intake intake = intakeRepository.findById(
                intakeId
        );

        if (intake == null) {
            throw new IllegalArgumentException(
                    "Intake não encontrado"
            );
        }

        IntakeAnswer answer = new IntakeAnswer();

        answer.setId(
                UUID.randomUUID()
        );

        answer.setIntakeId(
                intakeId
        );

        answer.setStepId(
                request.getStepId()
        );

        answer.setQuestion(
                request.getQuestion()
        );

        answer.setAnswer(
                request.getAnswer()
        );

        answer.setCreatedAt(
                LocalDateTime.now()
        );

        answerRepository.save(
                answer
        );

        return answer;
    }
}
package com.jusconnect.triage.application.mapper;

import com.jusconnect.triage.application.dto.request.CreateTriageRequest;
import com.jusconnect.triage.application.dto.response.TriageResponse;
import com.jusconnect.triage.application.dto.response.TriageScoreResponse;
import com.jusconnect.triage.application.dto.response.TriageSummaryResponse;
import com.jusconnect.triage.domain.model.Triage;

public final class TriageMapper {

    private TriageMapper() {
    }

    public static Triage toDomain(
            CreateTriageRequest request
    ) {

        if (request == null) {
            return null;
        }

        Triage triage = new Triage();

        triage.setIntakeId(
                request.getIntakeId()
        );

        triage.setLegalArea(
                request.getLegalArea()
        );

        triage.setUrgencyLevel(
                request.getUrgencyLevel()
        );

        triage.setNotes(
                request.getNotes()
        );

        return triage;
    }

    public static TriageResponse toResponse(
            Triage triage
    ) {

        if (triage == null) {
            return null;
        }

        TriageResponse response =
                new TriageResponse();

        response.setId(
                triage.getId()
        );

        response.setIntakeId(
                triage.getIntakeId()
        );

        response.setStatus(
                triage.getStatus()
        );

        response.setLegalArea(
                triage.getLegalArea()
        );

        response.setPriorityLevel(
                triage.getPriorityLevel()
        );

        response.setUrgencyLevel(
                triage.getUrgencyLevel()
        );

        response.setNotes(
                triage.getNotes()
        );

        response.setFinalScore(
                triage.getFinalScore()
        );

        response.setCreatedAt(
                triage.getCreatedAt()
        );

        response.setUpdatedAt(
                triage.getUpdatedAt()
        );

        return response;
    }

    public static TriageSummaryResponse toSummaryResponse(
            Triage triage
    ) {

        if (triage == null) {
            return null;
        }

        TriageSummaryResponse response =
                new TriageSummaryResponse();

        response.setId(
                triage.getId()
        );

        response.setIntakeId(
                triage.getIntakeId()
        );

        response.setStatus(
                triage.getStatus()
        );

        response.setLegalArea(
                triage.getLegalArea()
        );

        response.setPriorityLevel(
                triage.getPriorityLevel()
        );

        response.setFinalScore(
                triage.getFinalScore()
        );

        response.setCreatedAt(
                triage.getCreatedAt()
        );

        return response;
    }

    public static TriageScoreResponse toScoreResponse(
            Triage triage
    ) {

        TriageScoreResponse response =
                new TriageScoreResponse();

        response.setFinalScore(
                triage.getFinalScore()
        );

        response.setPriorityLevel(
                triage.getPriorityLevel()
        );

        return response;
    }
}
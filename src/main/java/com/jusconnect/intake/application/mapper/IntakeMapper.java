package com.jusconnect.intake.application.mapper;

import com.jusconnect.intake.application.dto.response.IntakeResponse;
import com.jusconnect.intake.application.dto.response.IntakeSummaryResponse;
import com.jusconnect.intake.domain.model.Intake;

public class IntakeMapper {

    private IntakeMapper() {
    }

    public static IntakeResponse toResponse(
            Intake intake
    ) {
        if (intake == null) {
            return null;
        }

        IntakeResponse response = new IntakeResponse();

        response.setId(intake.getId());
        response.setLeadId(intake.getLeadId());
        response.setStatus(
                intake.getStatus().name()
        );
        response.setType(
                intake.getType().name()
        );
        response.setCreatedAt(
                intake.getCreatedAt()
        );

        return response;
    }

    public static IntakeSummaryResponse toSummaryResponse(
            Intake intake
    ) {
        if (intake == null) {
            return null;
        }

        IntakeSummaryResponse response =
                new IntakeSummaryResponse();

        response.setId(intake.getId());
        response.setLeadId(intake.getLeadId());
        response.setStatus(
                intake.getStatus().name()
        );
        response.setType(
                intake.getType().name()
        );
        response.setCreatedAt(
                intake.getCreatedAt()
        );

        return response;
    }
}
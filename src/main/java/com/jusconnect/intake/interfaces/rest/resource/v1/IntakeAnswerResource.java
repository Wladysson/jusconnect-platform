package com.jusconnect.intake.interfaces.rest.resource.v1;

import com.jusconnect.intake.application.dto.request.SubmitAnswerRequest;
import com.jusconnect.intake.application.dto.response.IntakeAnswerResponse;
import com.jusconnect.intake.application.service.IntakeApplicationService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

@Path("/api/v1/intakes/{intakeId}/answers")
@Tag(
        name = "Intake Answer Resource",
        description = "Gestão de respostas da triagem"
)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IntakeAnswerResource {

    @Inject
    IntakeApplicationService service;

    @POST
    public IntakeAnswerResponse submit(
            @PathParam("intakeId") UUID intakeId,
            SubmitAnswerRequest request
    ) {
        return service.submitAnswer(intakeId, request);
    }

    @GET
    public List<IntakeAnswerResponse> list(@PathParam("intakeId") UUID intakeId) {
        return service.findAnswers(intakeId);
    }
}
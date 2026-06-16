package com.jusconnect.intake.interfaces.rest.resource.v1;

import com.jusconnect.intake.application.dto.request.UploadIntakeDocumentRequest;
import com.jusconnect.intake.application.dto.response.IntakeDocumentResponse;
import com.jusconnect.intake.application.service.IntakeApplicationService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

@Path("/api/v1/intakes/{intakeId}/documents")
@Tag(
        name = "IntakesDocument",
        description = "Gestão de documentos da triagem"
)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IntakeDocumentResource {

    @Inject
    IntakeApplicationService service;

    @POST
    public IntakeDocumentResponse upload(
            @PathParam("intakeId") UUID intakeId,
            UploadIntakeDocumentRequest request
    ) {
        return service.uploadDocument(intakeId, request);
    }

    @GET
    public List<IntakeDocumentResponse> list(@PathParam("intakeId") UUID intakeId) {
        return service.findDocuments(intakeId);
    }

    @DELETE
    @Path("/{documentId}")
    public void delete(
            @PathParam("intakeId") UUID intakeId,
            @PathParam("documentId") UUID documentId
    ) {
        service.deleteDocument(intakeId, documentId);
    }
}
package com.jusconnect.intake.interfaces.rest.resource.v1;

import com.jusconnect.intake.application.dto.request.CreateIntakeRequest;
import com.jusconnect.intake.application.dto.request.UpdateIntakeRequest;
import com.jusconnect.intake.application.dto.response.IntakeResponse;
import com.jusconnect.intake.application.service.IntakeApplicationService;

import com.jusconnect.intake.domain.model.Intake;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/api/v1/intakes")
@Tag(
        name = "Intakes",
        description = "Gestão de triagens"
)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IntakeResource {

    @Inject
    IntakeApplicationService service;

    @POST
    public Intake create(CreateIntakeRequest request) {
        return service.create(request);
    }

    @PUT
    @Path("/{id}")
    public IntakeResponse update(
            @PathParam("id") UUID id,
            UpdateIntakeRequest request
    ) {
        return service.update(id, request);
    }

    @GET
    @Path("/{id}")
    public Optional<Intake> findById(@PathParam("id") UUID id) {
        return service.findById(id);
    }

    @GET
    public List<Intake> findAll() {
        return service.findAll();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") UUID id) {
        service.delete(id);
    }
}
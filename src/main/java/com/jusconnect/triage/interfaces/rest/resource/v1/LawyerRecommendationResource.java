package com.jusconnect.triage.interfaces.rest.resource.v1;

import com.jusconnect.triage.application.usecase.SuggestLawyersUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/api/v1/triages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LawyerRecommendationResource {

    @Inject
    SuggestLawyersUseCase suggestLawyersUseCase;

    @GET
    @Path("/{id}/recommendations")
    public Response recommend(
            @PathParam("id")
            UUID triageId
    ) {

        return Response.ok(
                suggestLawyersUseCase.execute(
                        triageId
                )
        ).build();
    }
}
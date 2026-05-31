package com.jusconnect.lawyers.interfaces.rest.resource.v1;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.quarkus.security.Authenticated;

import com.jusconnect.lawyers.application.dto.request.UpdateAvailabilityRequest;
import com.jusconnect.lawyers.application.dto.response.AvailabilityResponse;
import com.jusconnect.lawyers.application.mapper.LawyerMapper;
import com.jusconnect.lawyers.application.usecase.UpdateAvailabilityUseCase;

import com.jusconnect.lawyers.domain.model.LawyerAvailability;

import java.util.UUID;

@Path("/api/v1/lawyers/availability")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AvailabilityResource {

    @Inject
    UpdateAvailabilityUseCase updateAvailabilityUseCase;

    @Inject
    LawyerMapper mapper;

    @PUT
    @Path("/{lawyerId}")
    @Authenticated
    public Response update(
            @PathParam("lawyerId") UUID lawyerId,
            UpdateAvailabilityRequest request
    ) {

        LawyerAvailability availability =
                updateAvailabilityUseCase.execute(
                        lawyerId,
                        request
                );

        AvailabilityResponse response =
                mapper.toResponse(availability);

        return Response.ok(response)
                .build();
    }
}
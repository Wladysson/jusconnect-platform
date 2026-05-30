package com.jusconnect.users.interfaces.rest.resource.v1;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.quarkus.security.Authenticated;

import com.jusconnect.users.application.dto.request.UpdateLawyerProfileRequest;
import com.jusconnect.users.application.dto.response.LawyerProfileResponse;
import com.jusconnect.users.application.usecase.UpdateLawyerProfileUseCase;
import com.jusconnect.users.application.mapper.UserMapper;

import com.jusconnect.users.domain.model.LawyerProfile;

import java.util.UUID;

@Path("/api/v1/lawyers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LawyerResource {

    @Inject
    UpdateLawyerProfileUseCase updateLawyerProfileUseCase;

    @Inject
    UserMapper userMapper;

    @PUT
    @Path("/{userId}")
    @Authenticated
    public Response updateProfile(
            @PathParam("userId") UUID userId,
            @Valid UpdateLawyerProfileRequest request
    ) {

        LawyerProfile profile =
                updateLawyerProfileUseCase.execute(
                        userId,
                        request
                );

        LawyerProfileResponse response =
                userMapper.toResponse(profile);

        return Response.ok(response).build();
    }
}
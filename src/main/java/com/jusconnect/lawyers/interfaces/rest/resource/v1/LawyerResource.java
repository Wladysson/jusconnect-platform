package com.jusconnect.lawyers.interfaces.rest.resource.v1;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.quarkus.security.Authenticated;

import com.jusconnect.lawyers.application.dto.request.CreateLawyerRequest;
import com.jusconnect.lawyers.application.dto.request.UpdateLawyerRequest;
import com.jusconnect.lawyers.application.dto.response.LawyerResponse;
import com.jusconnect.lawyers.application.mapper.LawyerMapper;
import com.jusconnect.lawyers.application.usecase.CreateLawyerUseCase;
import com.jusconnect.lawyers.application.usecase.GetLawyerByIdUseCase;
import com.jusconnect.lawyers.application.usecase.UpdateLawyerUseCase;
import com.jusconnect.lawyers.application.usecase.DeleteLawyerUseCase;

import com.jusconnect.lawyers.domain.model.Lawyer;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Path("/api/v1/lawyers")
@Tag(name = "Lawyers", description = "Gerenciamento de advogados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LawyerResource {

    @Inject
    CreateLawyerUseCase createLawyerUseCase;

    @Inject
    UpdateLawyerUseCase updateLawyerUseCase;

    @Inject
    GetLawyerByIdUseCase getLawyerByIdUseCase;

    @Inject
    DeleteLawyerUseCase deleteLawyerUseCase;

    @Inject
    LawyerMapper mapper;

    @POST
    @Authenticated
    public Response create(
            CreateLawyerRequest request
    ) {

        Lawyer lawyer =
                createLawyerUseCase.execute(request);

        LawyerResponse response =
                mapper.toResponse(lawyer);

        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(
            @PathParam("id") UUID id
    ) {

        Lawyer lawyer =
                getLawyerByIdUseCase.execute(id);

        return Response.ok(
                mapper.toResponse(lawyer)
        ).build();
    }

    @PUT
    @Path("/{id}")
    @Authenticated
    public Response update(
            @PathParam("id") UUID id,
            UpdateLawyerRequest request
    ) {

        Lawyer lawyer =
                updateLawyerUseCase.execute(
                        id,
                        request
                );

        return Response.ok(
                mapper.toResponse(lawyer)
        ).build();
    }

    @DELETE
    @Path("/{id}")
    @Authenticated
    public Response delete(
            @PathParam("id") UUID id
    ) {

        deleteLawyerUseCase.execute(id);

        return Response.noContent().build();
    }
}
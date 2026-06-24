package com.jusconnect.triage.interfaces.rest.resource.v1;

import com.jusconnect.triage.application.dto.request.CreateTriageRequest;
import com.jusconnect.triage.application.dto.request.SearchTriageRequest;
import com.jusconnect.triage.application.dto.response.TriageResponse;
import com.jusconnect.triage.application.mapper.TriageMapper;
import com.jusconnect.triage.application.usecase.CompleteTriageUseCase;
import com.jusconnect.triage.application.usecase.CreateTriageUseCase;
import com.jusconnect.triage.application.usecase.GetTriageByIdUseCase;
import com.jusconnect.triage.application.usecase.RecalculateTriageUseCase;
import com.jusconnect.triage.application.usecase.SearchTriagesUseCase;
import com.jusconnect.triage.domain.model.Triage;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/api/v1/triages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TriageResource {

    @Inject
    CreateTriageUseCase createTriageUseCase;

    @Inject
    GetTriageByIdUseCase getTriageByIdUseCase;

    @Inject
    SearchTriagesUseCase searchTriagesUseCase;

    @Inject
    RecalculateTriageUseCase recalculateTriageUseCase;

    @Inject
    CompleteTriageUseCase completeTriageUseCase;

    @POST
    public Response create(
            CreateTriageRequest request
    ) {

        Triage triage =
                createTriageUseCase.execute(
                        request
                );

        return Response
                .status(Response.Status.CREATED)
                .entity(
                        TriageMapper.toResponse(
                                triage
                        )
                )
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(
            @PathParam("id")
            UUID id
    ) {

        Triage triage =
                getTriageByIdUseCase.execute(
                        id
                );

        return Response.ok(
                TriageMapper.toResponse(
                        triage
                )
        ).build();
    }

    @POST
    @Path("/search")
    public Response search(
            SearchTriageRequest request
    ) {

        List<TriageResponse> response =
                searchTriagesUseCase.execute(
                                request
                        )
                        .stream()
                        .map(
                                TriageMapper::toResponse
                        )
                        .collect(
                                Collectors.toList()
                        );

        return Response.ok(
                response
        ).build();
    }

    @POST
    @Path("/{id}/recalculate")
    public Response recalculate(
            @PathParam("id")
            UUID id
    ) {

        Triage triage =
                recalculateTriageUseCase.execute(
                        id
                );

        return Response.ok(
                TriageMapper.toResponse(
                        triage
                )
        ).build();
    }

    @POST
    @Path("/{id}/complete")
    public Response complete(
            @PathParam("id")
            UUID id
    ) {

        Triage triage =
                completeTriageUseCase.execute(
                        id
                );

        return Response.ok(
                TriageMapper.toResponse(
                        triage
                )
        ).build();
    }
}
package com.jusconnect.leads.interfaces.rest.resource.v1;

import jakarta.inject.Inject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.jusconnect.leads.application.dto.request.CreateLeadRequest;
import com.jusconnect.leads.application.dto.request.SearchLeadRequest;
import com.jusconnect.leads.application.dto.request.UpdateLeadPriorityRequest;
import com.jusconnect.leads.application.dto.request.UpdateLeadRequest;

import com.jusconnect.leads.application.mapper.LeadMapper;
import com.jusconnect.leads.application.service.LeadApplicationService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Path("/api/v1/leads")
@Tag(
        name = "Leads",
        description = "Gestão de leads"
)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LeadResource {

    @Inject
    LeadApplicationService service;

    @Inject
    LeadMapper mapper;

    @POST
    public Response create(
            CreateLeadRequest request
    ) {

        return Response.status(
                        Response.Status.CREATED
                )
                .entity(
                        mapper.toResponse(
                                service.create(
                                        request
                                )
                        )
                )
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(
            @PathParam("id")
            UUID id,

            UpdateLeadRequest request
    ) {

        return Response.ok(
                        mapper.toResponse(
                                service.update(
                                        id,
                                        request
                                )
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

        return Response.ok(
                        mapper.toResponse(
                                service.findById(
                                        id
                                )
                        )
                )
                .build();
    }

    @POST
    @Path("/search")
    public Response search(
            SearchLeadRequest request
    ) {

        return Response.ok(
                        mapper.toLeadList(
                                service.search(
                                        request
                                )
                        )
                )
                .build();
    }

    @PATCH
    @Path("/{id}/priority")
    public Response updatePriority(
            @PathParam("id")
            UUID id,

            UpdateLeadPriorityRequest request
    ) {

        return Response.ok(
                        mapper.toResponse(
                                service.updatePriority(
                                        id,
                                        request
                                )
                        )
                )
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(
            @PathParam("id")
            UUID id
    ) {

        service.delete(
                id
        );

        return Response.noContent()
                .build();
    }
}
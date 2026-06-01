package com.jusconnect.leads.interfaces.rest.resource.v1;

import jakarta.inject.Inject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.jusconnect.leads.application.mapper.LeadMapper;
import com.jusconnect.leads.application.service.LeadApplicationService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Path("/api/v1/leads")
@Tag(
        name = "Lead History",
        description = "Histórico de leads"
)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LeadHistoryResource {

    @Inject
    LeadApplicationService service;

    @Inject
    LeadMapper mapper;

    @GET
    @Path("/{id}/history")
    public Response history(
            @PathParam("id")
            UUID leadId
    ) {

        return Response.ok(
                        mapper.toHistoryList(
                                service.history(
                                        leadId
                                )
                        )
                )
                .build();
    }

    @GET
    @Path("/{id}/score")
    public Response score(
            @PathParam("id")
            UUID leadId
    ) {

        return Response.ok(
                        mapper.toScoreResponse(
                                service.calculateScore(
                                        leadId
                                )
                        )
                )
                .build();
    }
}
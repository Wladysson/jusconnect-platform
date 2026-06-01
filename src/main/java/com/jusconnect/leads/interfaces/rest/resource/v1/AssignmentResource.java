package com.jusconnect.leads.interfaces.rest.resource.v1;

import jakarta.inject.Inject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.jusconnect.leads.application.dto.request.AssignLeadRequest;
import com.jusconnect.leads.application.mapper.LeadMapper;
import com.jusconnect.leads.application.service.LeadApplicationService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Path("/api/v1/leads")
@Tag(
        name = "Assignments",
        description = "Atribuição de leads"
)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AssignmentResource {

    @Inject
    LeadApplicationService service;

    @Inject
    LeadMapper mapper;

    @POST
    @Path("/{id}/assign")
    public Response assign(
            @PathParam("id")
            UUID leadId,

            AssignLeadRequest request
    ) {

        return Response.ok(
                        mapper.toAssignmentResponse(
                                service.assign(
                                        leadId,
                                        request
                                )
                        )
                )
                .build();
    }
}
package com.jusconnect.users.interfaces.rest.resource.v1;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

import com.jusconnect.users.application.dto.request.CreateUserRequest;
import com.jusconnect.users.application.dto.request.UpdateUserRequest;
import com.jusconnect.users.application.dto.response.UserResponse;
import com.jusconnect.users.application.service.UserApplicationService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Path("/api/v1/users")
@Tag(
        name = "Users",
        description = "Gestão de usuários"
)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserApplicationService userApplicationService;

    @Inject
    SecurityIdentity identity;

    @POST
    public Response create(
            @Valid CreateUserRequest request
    ) {

        UserResponse response =
                userApplicationService.create(request);

        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @GET
    @Path("/{id}")
    @Authenticated
    public Response getById(
            @PathParam("id") UUID id
    ) {

        UserResponse response =
                userApplicationService.getById(id);

        return Response.ok(response).build();
    }

    @PUT
    @Path("/{id}")
    @Authenticated
    public Response update(
            @PathParam("id") UUID id,
            @Valid UpdateUserRequest request
    ) {

        UserResponse response =
                userApplicationService.update(id, request);

        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    @Authenticated
    public Response delete(
            @PathParam("id") UUID id
    ) {

        userApplicationService.delete(id);

        return Response.noContent().build();
    }

    @GET
    @Path("/me")
    @Authenticated
    public Response me() {

        UUID userId = UUID.fromString(
                identity.getPrincipal().getName()
        );

        UserResponse response =
                userApplicationService.getById(userId);

        return Response.ok(response).build();
    }
}
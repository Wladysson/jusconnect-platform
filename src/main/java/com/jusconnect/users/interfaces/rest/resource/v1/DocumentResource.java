package com.jusconnect.users.interfaces.rest.resource.v1;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.quarkus.security.Authenticated;

import com.jusconnect.users.application.dto.response.DocumentResponse;
import com.jusconnect.users.application.usecase.UploadDocumentUseCase;
import com.jusconnect.users.application.mapper.UserMapper;

import com.jusconnect.users.domain.model.Document;

import java.util.UUID;

@Path("/api/v1/documents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentResource {

    @Inject
    UploadDocumentUseCase uploadDocumentUseCase;

    @Inject
    UserMapper userMapper;

    @POST
    @Path("/{userId}")
    @Authenticated
    public Response upload(
            @PathParam("userId") UUID userId
    ) {

        Document document =
                uploadDocumentUseCase.execute(userId);

        DocumentResponse response =
                userMapper.toResponse(document);

        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }
}
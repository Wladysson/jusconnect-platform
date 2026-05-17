package com.jusconnect.auth.interfaces.rest.resource.v1;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.jusconnect.auth.application.dto.request.LoginRequest;
import com.jusconnect.auth.application.dto.request.RefreshTokenRequest;
import com.jusconnect.auth.application.dto.request.RegisterRequest;
import com.jusconnect.auth.application.dto.response.LoginResponse;
import com.jusconnect.auth.application.dto.response.TokenResponse;
import com.jusconnect.auth.application.service.AuthApplicationService;
import com.jusconnect.auth.domain.model.UserCredential;

import java.util.Map;
import java.util.UUID;

@Path("/api/v1/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthApplicationService authApplicationService;

    @POST
    @Path("/login")
    @PermitAll
    public Response login(
            @Valid LoginRequest request
    ) {

        LoginResponse response =
                authApplicationService.login(request);

        return Response.ok(response).build();
    }

    @POST
    @Path("/register")
    @PermitAll
    public Response register(
            @Valid RegisterRequest request
    ) {

        UserCredential credential =
                authApplicationService.register(request);

        return Response.status(Response.Status.CREATED)
                .entity(credential)
                .build();
    }

    @POST
    @Path("/refresh")
    @PermitAll
    public Response refreshToken(
            @Valid RefreshTokenRequest request
    ) {

        TokenResponse response =
                authApplicationService.refreshToken(request);

        return Response.ok(response).build();
    }

    @POST
    @Path("/logout")
    public Response logout(
            @HeaderParam("X-USER-ID")
            UUID userCredentialId
    ) {

        authApplicationService.logout(userCredentialId);

        return Response.ok(
                Map.of(
                        "message",
                        "Logout realizado com sucesso"
                )
        ).build();
    }
}
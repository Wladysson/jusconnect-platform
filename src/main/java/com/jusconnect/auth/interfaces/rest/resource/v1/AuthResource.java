package com.jusconnect.auth.interfaces.rest.resource.v1;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

import com.jusconnect.auth.application.dto.request.*;
import com.jusconnect.auth.application.dto.response.*;
import com.jusconnect.auth.application.service.AuthApplicationService;
import com.jusconnect.auth.application.usecase.*;
import com.jusconnect.auth.domain.model.UserCredential;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.Map;
import java.util.UUID;

@Path("/api/v1/auth")
@Tag(name = "Authentication", description = "Autenticação e sessão")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthApplicationService authApplicationService;

    @Inject
    ForgotPasswordUseCase forgotPasswordUseCase;

    @Inject
    ResetPasswordUseCase resetPasswordUseCase;

    @Inject
    VerifyEmailUseCase verifyEmailUseCase;

    @Inject
    MeUseCase meUseCase;

    @Inject
    SessionUseCase sessionUseCase;

    @Inject
    SecurityIdentity identity;

    // LOGIN
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

    // REGISTER
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

    // REFRESH TOKEN
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

    // LOGOUT
    @POST
    @Path("/logout")
    @Authenticated
    public Response logout() {

        UUID userId =
                UUID.fromString(
                        identity
                                .getPrincipal()
                                .getName()
                );

        authApplicationService.logout(userId);

        return Response.ok(
                Map.of(
                        "message",
                        "Logout realizado com sucesso"
                )
        ).build();
    }

    // FORGOT PASSWORD
    @POST
    @Path("/password/forgot")
    @PermitAll
    public Response forgotPassword(
            @Valid ForgotPasswordRequest request
    ) {

        forgotPasswordUseCase.execute(request);

        return Response.ok(
                Map.of(
                        "message",
                        "Email de recuperação enviado"
                )
        ).build();
    }

    // RESET PASSWORD
    @POST
    @Path("/password/reset")
    @PermitAll
    public Response resetPassword(
            @Valid ResetPasswordRequest request
    ) {

        resetPasswordUseCase.execute(request);

        return Response.ok(
                Map.of(
                        "message",
                        "Senha redefinida com sucesso"
                )
        ).build();
    }

    // VERIFY EMAIL
    @POST
    @Path("/email/verify")
    @PermitAll
    public Response verifyEmail(
            @Valid VerifyEmailRequest request
    ) {

        verifyEmailUseCase.execute(request);

        return Response.ok(
                Map.of(
                        "message",
                        "Email verificado com sucesso"
                )
        ).build();
    }

    // CURRENT USER
    @GET
    @Path("/me")
    @Authenticated
    public Response me() {

        UUID userId =
                UUID.fromString(
                        identity
                                .getPrincipal()
                                .getName()
                );

        MeResponse response =
                meUseCase.execute(userId);

        return Response.ok(response).build();
    }

    // CURRENT SESSION
    @GET
    @Path("/session")
    @Authenticated
    public Response session() {

        UUID userId =
                UUID.fromString(
                        identity
                                .getPrincipal()
                                .getName()
                );

        SessionResponse response =
                sessionUseCase.execute(userId);

        return Response.ok(response).build();
    }
}
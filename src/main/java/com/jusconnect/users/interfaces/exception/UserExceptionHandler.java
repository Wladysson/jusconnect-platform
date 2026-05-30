package com.jusconnect.users.interfaces.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.Map;

@Provider
public class UserExceptionHandler
        implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(
            Exception exception
    ) {

        int status =
                Response.Status.INTERNAL_SERVER_ERROR
                        .getStatusCode();

        String message =
                "Erro interno no módulo users";

        if (exception instanceof WebApplicationException webEx) {

            status =
                    webEx.getResponse().getStatus();

            message =
                    webEx.getMessage();
        }

        Map<String, Object> body =
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", status,
                        "error", message
                );

        return Response
                .status(status)
                .entity(body)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
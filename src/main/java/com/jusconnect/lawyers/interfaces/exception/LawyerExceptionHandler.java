package com.jusconnect.lawyers.interfaces.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.Map;

@Provider
public class LawyerExceptionHandler
        implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(
            Exception exception
    ) {

        Response.Status status =
                Response.Status.INTERNAL_SERVER_ERROR;

        String message =
                exception.getMessage();

        if (exception instanceof IllegalArgumentException) {

            status =
                    Response.Status.BAD_REQUEST;
        }

        if (exception instanceof IllegalStateException) {

            status =
                    Response.Status.CONFLICT;
        }

        Map<String, Object> body =
                Map.of(
                        "timestamp",
                        LocalDateTime.now(),
                        "status",
                        status.getStatusCode(),
                        "error",
                        status.getReasonPhrase(),
                        "message",
                        message == null
                                ? "Erro interno"
                                : message
                );

        return Response.status(status)
                .type(MediaType.APPLICATION_JSON)
                .entity(body)
                .build();
    }
}
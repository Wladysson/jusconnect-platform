package com.jusconnect.leads.interfaces.rest.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Provider
public class LeadExceptionHandler
        implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(
            Exception exception
    ) {

        Map<String, Object> error =
                new HashMap<>();

        error.put(
                "timestamp",
                LocalDateTime.now()
        );

        error.put(
                "error",
                exception.getClass()
                        .getSimpleName()
        );

        error.put(
                "message",
                exception.getMessage()
        );

        error.put(
                "status",
                Response.Status.BAD_REQUEST
                        .getStatusCode()
        );

        return Response.status(
                        Response.Status.BAD_REQUEST
                )
                .entity(
                        error
                )
                .type(
                        MediaType.APPLICATION_JSON
                )
                .build();
    }
}
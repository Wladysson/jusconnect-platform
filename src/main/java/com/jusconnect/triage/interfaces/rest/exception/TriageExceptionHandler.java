package com.jusconnect.triage.interfaces.rest.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Provider
public class TriageExceptionHandler
        implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(
            Exception exception
    ) {

        Map<String, Object> body =
                new HashMap<>();

        body.put(
                "timestamp",
                LocalDateTime.now()
        );

        body.put(
                "message",
                exception.getMessage()
        );

        body.put(
                "error",
                exception.getClass().getSimpleName()
        );

        return Response
                .status(
                        Response.Status.BAD_REQUEST
                )
                .entity(
                        body
                )
                .build();
    }
}
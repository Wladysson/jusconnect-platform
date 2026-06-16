package com.jusconnect.intake.interfaces.rest.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IntakeExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(
                        new ErrorResponse(
                                exception.getMessage()
                        )
                )
                .build();
    }

    public record ErrorResponse(String message) {}
}
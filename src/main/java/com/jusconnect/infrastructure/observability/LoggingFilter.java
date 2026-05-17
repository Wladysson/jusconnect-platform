package com.jusconnect.infrastructure.observability;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.io.IOException;

@Provider
public class LoggingFilter
        implements ContainerRequestFilter {

    private static final Logger LOGGER =
            Logger.getLogger(LoggingFilter.class);

    @Override
    public void filter(
            ContainerRequestContext requestContext
    ) throws IOException {

        LOGGER.infof(
                "Request received: %s %s",
                requestContext.getMethod(),
                requestContext.getUriInfo().getPath()
        );
    }
}
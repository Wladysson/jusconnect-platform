package com.jusconnect.auth.infrastructure.security;

import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.runtime.QuarkusPrincipal;
import jakarta.enterprise.context.ApplicationScoped;

import java.security.Principal;

@ApplicationScoped
public class JwtIdentityProvider {

    public String getCurrentUserId(SecurityIdentity identity) {

        Principal principal = identity.getPrincipal();

        if (principal instanceof QuarkusPrincipal quarkusPrincipal) {
            return quarkusPrincipal.getName();
        }

        return null;
    }
}
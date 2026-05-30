package com.jusconnect.users.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.jusconnect.users.infrastructure.storage.*;

@ApplicationScoped
public class UserConfig {

    @ConfigProperty(name = "app.storage.type", defaultValue = "local")
    String storageType;

    @Inject
    LocalDocumentStorage localStorage;

    @Inject
    MinioDocumentStorage minioStorage;

    @Produces
    public DocumentStorageService documentStorageService() {

        return switch (storageType.toLowerCase()) {

            case "minio" -> minioStorage;

            default -> localStorage;
        };
    }
}
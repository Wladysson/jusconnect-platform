package com.jusconnect.users.infrastructure.storage;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.InputStream;
import java.util.UUID;

@ApplicationScoped
public class MinioDocumentStorage implements DocumentStorageService {

    // futuramente onde injeta MinioClient

    @Override
    public String upload(String fileName, InputStream content, String contentType) {

        String objectName = UUID.randomUUID() + "-" + fileName;

        // TODO: integração real com MinIO:
        // minioClient.putObject(...)

        return "minio://bucket/" + objectName;
    }

    @Override
    public void delete(String fileUrl) {

        // TODO: remover do MinIO
    }
}
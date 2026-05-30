package com.jusconnect.users.infrastructure.storage;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.UUID;

@ApplicationScoped
public class LocalDocumentStorage implements DocumentStorageService {

    private final String basePath = "uploads/";

    @Override
    public String upload(String fileName, InputStream content, String contentType) {

        try {
            Files.createDirectories(new File(basePath).toPath());

            String newFileName = UUID.randomUUID() + "-" + fileName;
            File file = new File(basePath + newFileName);

            try (FileOutputStream out = new FileOutputStream(file)) {
                content.transferTo(out);
            }

            return file.getAbsolutePath();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar arquivo local", e);
        }
    }

    @Override
    public void delete(String fileUrl) {

        try {
            Files.deleteIfExists(new File(fileUrl).toPath());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar arquivo local", e);
        }
    }
}
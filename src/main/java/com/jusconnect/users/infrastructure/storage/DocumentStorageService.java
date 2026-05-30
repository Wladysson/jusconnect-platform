package com.jusconnect.users.infrastructure.storage;

import java.io.InputStream;

public interface DocumentStorageService {

    String upload(String fileName, InputStream content, String contentType);

    void delete(String fileUrl);
}
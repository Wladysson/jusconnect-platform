package com.jusconnect.users.domain.repository;

import com.jusconnect.users.domain.model.Document;
import com.jusconnect.users.domain.enums.DocumentType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentRepository {

    Document save(Document document);

    Optional<Document> findById(UUID id);

    List<Document> findByUserId(UUID userId);

    Optional<Document> findByUserIdAndType(UUID userId, DocumentType type);

    void deleteById(UUID id);
}
package com.jusconnect.users.infrastructure.persistence.repository;

import com.jusconnect.users.domain.enums.DocumentType;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import com.jusconnect.users.domain.model.Document;
import com.jusconnect.users.domain.repository.DocumentRepository;

import com.jusconnect.users.infrastructure.persistence.entity.DocumentEntity;
import com.jusconnect.users.infrastructure.persistence.mapper.UserPersistenceMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class PanacheDocumentRepository implements DocumentRepository, PanacheRepository<DocumentEntity> {

    private final UserPersistenceMapper mapper;

    public PanacheDocumentRepository(UserPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Document> findByUserId(UUID userId) {

        return find("userId", userId)
                .list()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Document> findByUserIdAndType(UUID userId, DocumentType type) {
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Document save(Document document) {

        DocumentEntity entity = mapper.toEntity(document);

        persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Document> findById(UUID id) {
        return Optional.empty();
    }
}
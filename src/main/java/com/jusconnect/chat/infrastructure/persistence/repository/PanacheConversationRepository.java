package com.jusconnect.chat.infrastructure.persistence.repository;

import com.jusconnect.chat.domain.model.Conversation;
import com.jusconnect.chat.domain.repository.ConversationRepository;
import com.jusconnect.chat.infrastructure.persistence.entity.ConversationEntity;
import com.jusconnect.chat.infrastructure.persistence.mapper.ChatPersistenceMapper;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheConversationRepository implements
        PanacheRepositoryBase<ConversationEntity, UUID>,
        ConversationRepository {

    // Mapper de persistência
    @Inject
    ChatPersistenceMapper mapper;

    @Override
    @Transactional
    public Conversation save(Conversation conversation) {

        ConversationEntity entity = mapper.toEntity(conversation);

        persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    @Transactional
    public Conversation update(Conversation conversation) {

        ConversationEntity entity = mapper.toEntity(conversation);

        getEntityManager().merge(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Conversation> findById(UUID conversationId) {

        return findByIdOptional(conversationId)
                .map(mapper::toDomain);
    }

    @Override
    public List<Conversation> findByUserId(UUID userId) {

        return list("SELECT DISTINCT c FROM ConversationEntity c JOIN c.participantsIds p WHERE p = ?1", userId)
                .stream()
                .map(entity -> mapper.toDomain((ConversationEntity) entity))
                .toList();
    }

    @Override
    public List<Conversation> search(UUID userId, String searchTerm) {

        return find("LOWER(name) LIKE LOWER(?1)", "%" + searchTerm + "%")
                .list()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsById(UUID conversationId) {

        return findByIdOptional(conversationId).isPresent();
    }

    @Override
    @Transactional
    public void delete(UUID conversationId) {

        deleteById(conversationId);
    }

}
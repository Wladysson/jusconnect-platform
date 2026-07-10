package com.jusconnect.chat.infrastructure.persistence.repository;

import com.jusconnect.chat.domain.model.Conversation;
import com.jusconnect.chat.domain.repository.ConversationRepository;
import com.jusconnect.chat.infrastructure.persistence.entity.ConversationEntity;
import com.jusconnect.chat.infrastructure.persistence.mapper.ChatPersistenceMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheConversationRepository implements ConversationRepository {

    @Inject
    ConversationPanacheRepository repository;

    // Mapper de persistência
    @Inject
    ChatPersistenceMapper mapper;

    @Override
    @Transactional
    public Conversation save(Conversation conversation) {

        ConversationEntity entity = mapper.toEntity(conversation);

        repository.persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    @Transactional
    public Conversation update(Conversation conversation) {

        ConversationEntity entity = mapper.toEntity(conversation);

        repository.getEntityManager().merge(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Conversation> findById(UUID conversationId) {

        return repository.find("id", conversationId)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public List<Conversation> findByUserId(UUID userId) {

        return repository.find("SELECT DISTINCT c FROM ConversationEntity c JOIN c.participantsIds p WHERE p = ?1", userId)
                .list()
                .stream()
                .map(entity -> mapper.toDomain((ConversationEntity) entity))
                .toList();
    }

    @Override
    public List<Conversation> search(UUID userId, String searchTerm) {

        return repository.find("LOWER(name) LIKE LOWER(?1)", "%" + searchTerm + "%")
                .list()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Integer countUnreadByUserId(UUID userId) {

        // Count conversations where the user is a participant and there are unread messages
        return repository.find("SELECT DISTINCT c FROM ConversationEntity c JOIN c.participantsIds p WHERE p = ?1 AND c.unreadMessages > 0", userId)
                .list()
                .size();
    }

    @Override
    public boolean existsById(UUID conversationId) {

        return repository.find("id", conversationId).firstResultOptional().isPresent();
    }

    @Override
    @Transactional
    public void delete(UUID conversationId) {

        repository.deleteById(conversationId);
    }

}


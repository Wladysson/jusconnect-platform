package com.jusconnect.chat.infrastructure.persistence.repository;

import com.jusconnect.chat.domain.model.Message;
import com.jusconnect.chat.domain.repository.MessageRepository;
import com.jusconnect.chat.infrastructure.persistence.entity.MessageEntity;
import com.jusconnect.chat.infrastructure.persistence.mapper.ChatPersistenceMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheMessageRepository implements MessageRepository {

    @Inject
    MessagePanacheRepository repository;

    // Mapper de persistência
    @Inject
    ChatPersistenceMapper mapper;

    @Override
    @Transactional
    public Message save(Message message) {

        MessageEntity entity = mapper.toEntity(message);

        repository.persist(entity);

        return mapper.toDomain(entity);
    }

    @Override
    @Transactional
    public Message update(Message message) {

        MessageEntity entity = mapper.toEntity(message);

        repository.getEntityManager().merge(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Message> findById(UUID messageId) {

        return repository.find("id", messageId)
                .firstResultOptional()
                .map(mapper::toDomain);
    }

    @Override
    public List<Message> findByConversationId(UUID conversationId) {

        return repository.list("conversationId", conversationId)
                .stream()
                .map(entity -> mapper.toDomain((MessageEntity) entity))
                .toList();
    }

    @Override
    public List<Message> findUnreadMessages(UUID userId) {

        return repository.list("status", "SENT")
                .stream()
                .map(entity -> mapper.toDomain((MessageEntity) entity))
                .toList();
    }

    @Override
    @Transactional
    public void delete(UUID messageId) {

        repository.deleteById(messageId);
    }

    @Override
    public Integer countUnreadByUserId(UUID userId) {

        // Simple count of messages with status SENT; adapt if recipient tracking is added
        return Math.toIntExact(repository.count("status", "SENT"));
    }

    @Override
    public boolean existsById(UUID messageId) {

        return repository.find("id", messageId).firstResultOptional().isPresent();
    }

}


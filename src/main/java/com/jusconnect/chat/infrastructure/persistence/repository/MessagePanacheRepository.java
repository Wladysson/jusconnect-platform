package com.jusconnect.chat.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import com.jusconnect.chat.infrastructure.persistence.entity.MessageEntity;
import java.util.UUID;

@ApplicationScoped
public class MessagePanacheRepository implements PanacheRepositoryBase<MessageEntity, UUID> {
}

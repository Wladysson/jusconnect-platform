package com.jusconnect.chat.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import com.jusconnect.chat.infrastructure.persistence.entity.ConversationEntity;
import java.util.UUID;

@ApplicationScoped
public class ConversationPanacheRepository implements PanacheRepositoryBase<ConversationEntity, UUID> {
}

package com.jusconnect.leads.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import com.jusconnect.leads.domain.model.LeadHistory;
import com.jusconnect.leads.domain.repository.LeadHistoryRepository;

import com.jusconnect.leads.infrastructure.persistence.entity.LeadHistoryEntity;
import com.jusconnect.leads.infrastructure.persistence.mapper.LeadPersistenceMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheLeadHistoryRepository
        implements LeadHistoryRepository,
        PanacheRepository<LeadHistoryEntity> {

    @Inject
    LeadPersistenceMapper mapper;

    @Override
    public LeadHistory save(
            LeadHistory history
    ) {

        LeadHistoryEntity entity =
                new LeadHistoryEntity();

        entity.setId(
                history.getId()
        );

        entity.setLeadId(
                history.getLeadId()
        );

        entity.setAction(
                history.getAction()
        );

        entity.setDescription(
                history.getDescription()
        );

        entity.setCreatedAt(
                history.getCreatedAt()
        );

        if (findById(
                entity.getId()
        ) == null) {

            persist(
                    entity
            );

        } else {

            getEntityManager()
                    .merge(
                            entity
                    );
        }

        return mapper.toDomain(
                entity
        );
    }

    @Override
    public Optional<LeadHistory> findById(
            UUID id
    ) {

        return find(
                "id",
                id
        )
                .firstResultOptional()
                .map(
                        mapper::toDomain
                );
    }

    @Override
    public List<LeadHistory> findByLeadId(
            UUID leadId
    ) {

        return find(
                "leadId",
                leadId
        )
                .list()
                .stream()
                .map(
                        mapper::toDomain
                )
                .toList();
    }

    @Override
    public void deleteById(
            UUID id
    ) {

        delete(
                "id",
                id
        );
    }
}
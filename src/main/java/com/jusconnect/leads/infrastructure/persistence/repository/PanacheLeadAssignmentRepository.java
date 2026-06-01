package com.jusconnect.leads.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import com.jusconnect.leads.domain.model.LeadAssignment;
import com.jusconnect.leads.domain.repository.LeadAssignmentRepository;

import com.jusconnect.leads.infrastructure.persistence.entity.LeadAssignmentEntity;
import com.jusconnect.leads.infrastructure.persistence.mapper.LeadPersistenceMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheLeadAssignmentRepository
        implements LeadAssignmentRepository,
        PanacheRepository<LeadAssignmentEntity> {

    @Inject
    LeadPersistenceMapper mapper;

    @Override
    public LeadAssignment save(
            LeadAssignment assignment
    ) {

        LeadAssignmentEntity entity =
                mapper.toEntity(
                        assignment
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
    public Optional<LeadAssignment> findById(
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
    public Optional<LeadAssignment> findByLeadId(
            UUID leadId
    ) {

        return find(
                "leadId",
                leadId
        )
                .firstResultOptional()
                .map(
                        mapper::toDomain
                );
    }

    @Override
    public List<LeadAssignment> findByLawyerId(
            UUID lawyerId
    ) {

        return find(
                "lawyerId",
                lawyerId
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
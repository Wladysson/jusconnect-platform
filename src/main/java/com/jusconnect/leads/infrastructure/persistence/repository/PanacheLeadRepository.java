package com.jusconnect.leads.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.repository.LeadRepository;

import com.jusconnect.leads.infrastructure.persistence.entity.LeadEntity;
import com.jusconnect.leads.infrastructure.persistence.mapper.LeadPersistenceMapper;

import io.quarkus.panache.common.Parameters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheLeadRepository
        implements LeadRepository,
        PanacheRepository<LeadEntity> {

    @Inject
    LeadPersistenceMapper mapper;

    @Override
    public Lead save(
            Lead lead
    ) {

        LeadEntity entity =
                mapper.toEntity(
                        lead
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
    public Optional<Lead> findById(
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
    public List<Lead> findAll() {

        return listAll()
                .stream()
                .map(
                        mapper::toDomain
                )
                .toList();
    }

    @Override
    public List<Lead> search(
            String legalArea,
            String status
    ) {

        return find(
                "(:legalArea is null or legalArea = :legalArea) " +
                        "and (:status is null or status = :status)",

                Parameters.with(
                                "legalArea",
                                legalArea
                        )
                        .and(
                                "status",
                                status
                        )
        )
                .list()
                .stream()
                .map(
                        mapper::toDomain
                )
                .toList();
    }

    @Override
    public boolean existsByEmail(
            String email
    ) {

        return count(
                "email",
                email
        ) > 0;
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
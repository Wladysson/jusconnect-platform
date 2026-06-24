package com.jusconnect.triage.infrastructure.persistence.mapper;

import com.jusconnect.triage.domain.enums.LegalArea;
import com.jusconnect.triage.domain.enums.PriorityLevel;
import com.jusconnect.triage.domain.enums.TriageStatus;
import com.jusconnect.triage.domain.enums.UrgencyLevel;
import com.jusconnect.triage.domain.model.Triage;
import com.jusconnect.triage.infrastructure.persistence.entity.TriageEntity;

public final class TriagePersistenceMapper {

    private TriagePersistenceMapper() {
    }

    public static TriageEntity toEntity(
            Triage triage
    ) {

        if (triage == null) {
            return null;
        }

        TriageEntity entity =
                new TriageEntity();

        entity.setId(
                triage.getId()
        );

        entity.setIntakeId(
                triage.getIntakeId()
        );

        entity.setLegalArea(
                triage.getLegalArea() != null
                        ? triage.getLegalArea().name()
                        : null
        );

        entity.setPriorityLevel(
                triage.getPriorityLevel() != null
                        ? triage.getPriorityLevel().name()
                        : null
        );

        entity.setUrgencyLevel(
                triage.getUrgencyLevel() != null
                        ? triage.getUrgencyLevel().name()
                        : null
        );

        entity.setStatus(
                triage.getStatus() != null
                        ? triage.getStatus().name()
                        : null
        );

        entity.setScore(
                triage.getScore()
        );

        entity.setNotes(
                triage.getNotes()
        );

        entity.setCreatedAt(
                triage.getCreatedAt()
        );

        entity.setUpdatedAt(
                triage.getUpdatedAt()
        );

        return entity;
    }

    public static Triage toDomain(
            TriageEntity entity
    ) {

        if (entity == null) {
            return null;
        }

        Triage triage =
                new Triage();

        triage.setId(
                entity.getId()
        );

        triage.setIntakeId(
                entity.getIntakeId()
        );

        if (entity.getLegalArea() != null) {
            triage.setLegalArea(
                    LegalArea.valueOf(
                            entity.getLegalArea()
                    )
            );
        }

        if (entity.getPriorityLevel() != null) {
            triage.setPriorityLevel(
                    PriorityLevel.valueOf(
                            entity.getPriorityLevel()
                    )
            );
        }

        if (entity.getUrgencyLevel() != null) {
            triage.setUrgencyLevel(
                    UrgencyLevel.valueOf(
                            entity.getUrgencyLevel()
                    )
            );
        }

        if (entity.getStatus() != null) {
            triage.setStatus(
                    TriageStatus.valueOf(
                            entity.getStatus()
                    )
            );
        }

        triage.setScore(
                entity.getScore()
        );

        triage.setNotes(
                entity.getNotes()
        );

        triage.setCreatedAt(
                entity.getCreatedAt()
        );

        triage.setUpdatedAt(
                entity.getUpdatedAt()
        );

        return triage;
    }
}
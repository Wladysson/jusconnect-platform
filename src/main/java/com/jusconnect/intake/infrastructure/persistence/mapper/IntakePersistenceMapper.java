package com.jusconnect.intake.infrastructure.persistence.mapper;

import com.jusconnect.intake.domain.enums.IntakeStatus;
import com.jusconnect.intake.domain.enums.IntakeType;
import com.jusconnect.intake.domain.model.Intake;
import com.jusconnect.intake.infrastructure.persistence.entity.IntakeEntity;

public final class IntakePersistenceMapper {

    private IntakePersistenceMapper() {
    }

    public static IntakeEntity toEntity(
            Intake intake
    ) {

        if (intake == null) {
            return null;
        }

        IntakeEntity entity = new IntakeEntity();

        entity.setId(
                intake.getId()
        );

        entity.setUserId(
                intake.getUserId()
        );

        entity.setType(
                intake.getType()
        );

        entity.setType(
                intake.getType()
        );

        entity.setCreatedAt(
                intake.getCreatedAt()
        );

        entity.setUpdatedAt(
                intake.getUpdatedAt()
        );

        return entity;
    }

    public static Intake toDomain(
            IntakeEntity entity
    ) {

        if (entity == null) {
            return null;
        }

        Intake intake = new Intake();

        intake.setId(
                entity.getId()
        );

        intake.setUserId(
                entity.getUserId()
        );

        intake.setType(
                String.valueOf(IntakeType.valueOf(
                        entity.getType()
                ))
        );

        intake.setStatus(
                String.valueOf(IntakeStatus.valueOf(
                        entity.getStatus()
                ))
        );

        intake.setCreatedAt(
                entity.getCreatedAt()
        );

        intake.setUpdatedAt(
                entity.getUpdatedAt()
        );

        return intake;
    }
}
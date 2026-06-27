package com.jusconnect.scheduling.infrastructure.persistence.repository;

import com.jusconnect.scheduling.infrastructure.persistence.entity.AppointmentEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AppointmentPanacheRepository implements PanacheRepository<AppointmentEntity> {

    public List<AppointmentEntity> findByLawyerId(UUID lawyerId) {
        return find("lawyerId", lawyerId).list();
    }

    public List<AppointmentEntity> findConflicts(UUID lawyerId, LocalDateTime start, LocalDateTime end) {
        return find("lawyerId = ?1 and startTime < ?3 and endTime > ?2",
                lawyerId, start, end).list();
    }

    public List<AppointmentEntity> findByClientId(UUID clientId) {
        return find("clientId", clientId).list();
    }
}
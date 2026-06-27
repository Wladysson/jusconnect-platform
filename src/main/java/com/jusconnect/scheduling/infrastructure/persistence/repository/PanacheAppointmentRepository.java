package com.jusconnect.scheduling.infrastructure.persistence.repository;

import com.jusconnect.scheduling.infrastructure.persistence.entity.AppointmentEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheAppointmentRepository implements PanacheRepository<AppointmentEntity> {

    public List<AppointmentEntity> findByLawyerId(UUID lawyerId) {
        return find("lawyerId", lawyerId).list();
    }

    public List<AppointmentEntity> findByClientId(UUID clientId) {
        return find("clientId", clientId).list();
    }

    // 🔥 CRÍTICO NO JUSCONNECT: conflito de agenda
    public List<AppointmentEntity> findConflicts(UUID lawyerId,
                                                 LocalDateTime start,
                                                 LocalDateTime end) {

        return find("""
                lawyerId = ?1
                AND status != 'CANCELED'
                AND startTime < ?3
                AND endTime > ?2
                """,
                lawyerId, start, end
        ).list();
    }

    public List<AppointmentEntity> findByPeriod(UUID lawyerId,
                                                LocalDateTime start,
                                                LocalDateTime end) {

        return find("""
                lawyerId = ?1
                AND startTime >= ?2
                AND endTime <= ?3
                """,
                lawyerId, start, end
        ).list();
    }

    public <T> Optional<T> findByIdOptional(UUID id) {
        return Optional.empty();
    }

    public void deleteById(UUID id) {
    }
}
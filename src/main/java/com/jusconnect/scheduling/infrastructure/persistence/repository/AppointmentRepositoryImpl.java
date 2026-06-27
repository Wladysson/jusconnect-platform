package com.jusconnect.scheduling.infrastructure.persistence.repository;

import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.repository.AppointmentRepository;
import com.jusconnect.scheduling.infrastructure.persistence.mapper.AppointmentPersistenceMapper;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private final PanacheAppointmentRepository panache;

    public AppointmentRepositoryImpl(PanacheAppointmentRepository panache) {
        this.panache = panache;
    }

    @Override
    public Appointment save(Appointment appointment) {
        var entity = AppointmentPersistenceMapper.toEntity(appointment);
        panache.persist(entity);
        return AppointmentPersistenceMapper.toDomain(entity);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return null;
    }

    @Override
    public Optional<Appointment> findById(UUID id) {
        return panache.findByIdOptional(id)
                .map((java.util.function.Function<? super Object, ? extends Appointment>) AppointmentPersistenceMapper::toDomain);
    }

    @Override
    public List<Appointment> search(String status, UUID lawyerId, UUID clientId, String appointmentType) {
        return List.of();
    }

    @Override
    public void delete(UUID id) {
        panache.deleteById(id);
    }

    @Override
    public List<Appointment> findConflicts(UUID lawyerId,
                                           LocalDateTime start,
                                           LocalDateTime end) {

        return panache.find("""
                lawyerId = ?1
                AND status != 'CANCELED'
                AND startTime < ?3
                AND endTime > ?2
                """,
                        lawyerId, start, end)
                .list()
                .stream()
                .map(AppointmentPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public List<Appointment> findOccupiedSlots(UUID lawyerId, LocalDate date) {

        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.plusDays(1).atStartOfDay();

        return panache.find("""
                lawyerId = ?1
                AND status != 'CANCELED'
                AND startTime >= ?2
                AND startTime < ?3
                """,
                        lawyerId, startOfDay, endOfDay)
                .list()
                .stream()
                .map(AppointmentPersistenceMapper::toDomain)
                .toList();
    }
}
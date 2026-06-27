package com.jusconnect.scheduling.infrastructure.persistence.mapper;

import com.jusconnect.scheduling.domain.model.Appointment;
import com.jusconnect.scheduling.domain.model.AppointmentId;
import com.jusconnect.scheduling.infrastructure.persistence.entity.AppointmentEntity;
import java.util.UUID;

import java.lang.reflect.Field;

public class AppointmentPersistenceMapper {

    public static Appointment toDomain(AppointmentEntity entity) {
        if (entity == null) return null;

        try {
            Appointment appointment = new Appointment();

            setField(appointment, "id", new AppointmentId(entity.getId()));
            setField(appointment, "lawyerId", entity.getLawyerId());
            setField(appointment, "clientId", entity.getClientId());
            setField(appointment, "startTime", entity.getStartTime());
            setField(appointment, "endTime", entity.getEndTime());
            setField(appointment, "status", entity.getStatus());
            setField(appointment, "type", entity.getType());
            setField(appointment, "notes", entity.getNotes());

            return appointment;

        } catch (Exception e) {
            throw new RuntimeException("Error mapping AppointmentEntity -> Appointment", e);
        }
    }

    public static AppointmentEntity toEntity(Appointment domain) {
        if (domain == null) return null;

        AppointmentEntity entity = new AppointmentEntity();

        entity.setId(getUUID(domain, "id"));
        entity.setLawyerId(getUUID(domain, "lawyerId"));
        entity.setClientId(getUUID(domain, "clientId"));
        entity.setStartTime(getValue(domain, "startTime"));
        entity.setEndTime(getValue(domain, "endTime"));
        entity.setStatus(getValue(domain, "status"));
        entity.setType(getValue(domain, "type"));
        entity.setNotes(getString(domain, "notes"));

        return entity;
    }

    // =========================
    // Reflection helpers (safe fallback)
    // =========================

    private static void setField(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception ignored) {
        }
    }

    private static UUID getUUID(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (UUID) field.get(obj);
        } catch (Exception e) {
            return null;
        }
    }

    private static <T> T getValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Exception e) {
            return null;
        }
    }

    private static String getString(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (String) field.get(obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static Appointment toDomain(Object o) {
        return null;
    }
}
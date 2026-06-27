package com.jusconnect.scheduling.domain.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class AppointmentId implements Serializable {

    private UUID value;

    public AppointmentId() {
    }

    public AppointmentId(
            UUID value
    ) {
        this.value = value;
    }

    public static AppointmentId generate() {
        return new AppointmentId(
                UUID.randomUUID()
        );
    }

    public UUID getValue() {
        return value;
    }

    public void setValue(
            UUID value
    ) {
        this.value = value;
    }

    @Override
    public boolean equals(
            Object o
    ) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof AppointmentId)) {
            return false;
        }

        AppointmentId that =
                (AppointmentId) o;

        return Objects.equals(
                value,
                that.value
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                value
        );
    }

    @Override
    public String toString() {
        return value != null
                ? value.toString()
                : null;
    }
}
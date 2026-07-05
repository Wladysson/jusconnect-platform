package com.jusconnect.chat.domain.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class ConversationId implements Serializable {

    // Valor do identificador
    private UUID value;

    public ConversationId() {
        this.value = UUID.randomUUID();
    }

    public ConversationId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    public void setValue(UUID value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof ConversationId other)) {
            return false;
        }

        return Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
package com.jusconnect.shared.kernel.domain;

import java.util.Objects;

public abstract class Entity<ID> {

    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (object == null ||
                getClass() != object.getClass()) {
            return false;
        }

        Entity<?> entity = (Entity<?>) object;

        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
package br.com.marketplace.shared.domain.tactical_ddd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Entity<I extends Identifier<?>> {

    protected List<DomainEvent> domainEvents = new ArrayList<>();

    protected void registerEvent(DomainEvent event) {
        this.domainEvents.add(event);
    }

    protected List<DomainEvent> domainEvents() {
        return Collections.unmodifiableList(this.domainEvents);
    }

    protected void clearDomainEvents() {
        this.domainEvents.clear();
    }

    protected final I id;

    protected Entity(I id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public I getId() {
        return id;
    }
}

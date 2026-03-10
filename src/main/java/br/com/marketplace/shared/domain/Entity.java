package br.com.marketplace.shared.domain;

public abstract class Entity<I extends Identifier> implements DomainEvent {

    protected final I id;

    protected Entity(I id) {
        this.id = id;
    }

    public I getId() {
        return id;
    }
}

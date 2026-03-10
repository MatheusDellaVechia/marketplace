package br.com.marketplace.shared.domain;

import static java.util.Objects.requireNonNull;

public abstract class AggregateRoot<I extends Identifier> extends Entity<I> {

    AggregateRoot(I id) {
        requireNonNull(id, "The id must not be null");
        super(id);
    }
}

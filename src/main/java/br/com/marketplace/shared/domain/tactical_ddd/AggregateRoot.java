package br.com.marketplace.shared.domain.tactical_ddd;

import static java.util.Objects.requireNonNull;

public abstract class AggregateRoot<I extends Identifier<?>>
        extends Entity<I> {

    protected AggregateRoot(I id) {
        requireNonNull(id, "The id must not be null");
        super(id);
    }
}

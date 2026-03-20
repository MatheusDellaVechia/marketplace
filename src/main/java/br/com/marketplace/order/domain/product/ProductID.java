package br.com.marketplace.order.domain.product;

import br.com.marketplace.shared.domain.tactical_ddd.Identifier;

public record ProductID(Long value)
        implements Identifier<Long> {

    @Override
    public Long getValue() {
        return this.value;
    }

    public static ProductID from(final Long value) {
        return new ProductID(value);
    }
}

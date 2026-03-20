package br.com.marketplace.order.domain.customer;

import br.com.marketplace.shared.domain.tactical_ddd.Identifier;

public record CustomerID(Long value)
        implements Identifier<Long> {

    @Override
    public Long getValue() {
        return this.value;
    }

    public static CustomerID from(final Long valueNumber) {
        return new CustomerID(valueNumber);
    }
}

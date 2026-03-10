package br.com.marketplace.order.domain.customer;

import br.com.marketplace.shared.domain.Identifier;

public record CustomerID(Long value) implements Identifier {

    @Override
    public Long getValue() {
        return this.value;
    }
}

package br.com.marketplace.order.domain.product;

import br.com.marketplace.shared.domain.Identifier;

public record ProductID(Long value) implements Identifier {

    @Override
    public Long getValue() {
        return this.value;
    }
}

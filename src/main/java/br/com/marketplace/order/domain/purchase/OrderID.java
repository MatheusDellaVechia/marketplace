package br.com.marketplace.order.domain.purchase;

import br.com.marketplace.shared.domain.Identifier;

public record OrderID(Long value) implements Identifier {

    @Override
    public Long getValue() {
        return this.value;
    }
}

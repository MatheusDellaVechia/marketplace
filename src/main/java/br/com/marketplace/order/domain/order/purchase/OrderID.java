package br.com.marketplace.order.domain.order.purchase;


import br.com.marketplace.shared.domain.tactical_ddd.Identifier;

public record OrderID(Long value)
        implements Identifier<Long> {

    @Override
    public Long getValue() {
        return this.value;
    }
}

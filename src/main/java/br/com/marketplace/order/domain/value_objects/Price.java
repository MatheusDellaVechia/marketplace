package br.com.marketplace.order.domain.value_objects;

import br.com.marketplace.shared.domain.exceptions.DomainException;

import java.math.BigDecimal;

public record Price(BigDecimal value) {

    public Price {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0)
            throw new DomainException("Price must be a positive value");
    }
}

package br.com.marketplace.order.domain.value_objects;

import br.com.marketplace.shared.domain.exceptions.DomainException;

public record SKU(String value) {

    public SKU {
        if (value == null || value.isBlank())
            throw new DomainException("Sku cannot be null or empty");
    }
}

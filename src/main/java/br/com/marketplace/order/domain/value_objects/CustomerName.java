package br.com.marketplace.order.domain.value_objects;

import br.com.marketplace.shared.domain.exceptions.DomainException;

public record CustomerName(String value) {

    public CustomerName {
        if (value == null || value.isBlank())
            throw new DomainException("Name cannot be null or empty");

        if (!value.matches("^[a-zA-Z]+\\s+[a-zA-Z]+.*$"))
            throw new DomainException("Name and Second Name is required");

    }
}

package br.com.marketplace.order.domain.value_objects;

public record TaxID(String value) {

    public TaxID {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Tax ID cannot be null or empty");
        if (!value.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"))
            throw new IllegalArgumentException("Tax ID must follow the pattern XXX.XXX.XXX-XX");
    }
}

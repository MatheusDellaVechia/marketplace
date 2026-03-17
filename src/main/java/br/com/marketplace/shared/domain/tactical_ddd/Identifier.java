package br.com.marketplace.shared.domain.tactical_ddd;

public interface Identifier<T> {

    T getValue();

    default boolean isNew() {
        return getValue() == null;
    }

    static <ID extends Identifier<?>> ID create() {
        throw new UnsupportedOperationException(
                "Subclasses must implement create()"
        );
    }

    static <ID extends Identifier<?>> ID with(Object value) {
        throw new UnsupportedOperationException(
                "Subclasses must implement with()"
        );
    }
}

package br.com.marketplace.order.application;

public record CreateOrderCommand(
        Long customerId,
        Long productId,
        Integer quantity
) {

    public static CreateOrderCommand with(
            Long customerId,
            Long productId,
            Integer quantity
    ) {
        return new CreateOrderCommand(customerId, productId, quantity);
    }
}

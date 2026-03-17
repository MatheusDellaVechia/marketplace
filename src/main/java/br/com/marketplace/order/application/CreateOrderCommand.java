package br.com.marketplace.order.application;

public record CreateOrderCommand(
        Long customerId,
        Long productId,
        Integer quantity
) {
}

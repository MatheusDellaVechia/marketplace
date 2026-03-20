package br.com.marketplace.order.infrastructure.api.order.models;

public record CreateOrderRequest(
        Long customerId,
        Long productId,
        int quantity
) {
}

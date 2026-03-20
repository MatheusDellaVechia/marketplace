package br.com.marketplace.order.domain.order.purchase;


import br.com.marketplace.shared.domain.tactical_ddd.DomainEvent;

import java.time.Instant;

public record OrderCreatedEvent(
        Long orderId,
        Long customerId,
        Long productId,
        Integer quantity,
        Instant occurredOn
) implements DomainEvent {

    public OrderCreatedEvent {
        if (occurredOn == null) {
            occurredOn = Instant.now();
        }
    }

    public static OrderCreatedEvent from(Order order) {
        return new OrderCreatedEvent(
                order.getId().getValue(),
                order.getCustomerId().getValue(),
                order.getProductId().getValue(),
                order.getQuantity(),
                Instant.now()
        );
    }
}

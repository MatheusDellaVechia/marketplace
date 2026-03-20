package br.com.marketplace.order.infrastructure.api.order.models;

import br.com.marketplace.order.application.CreateCommandOutput;
import br.com.marketplace.order.domain.order.purchase.OrderStatus;

public record CreateOrderResponse(
        Long orderId,
        OrderStatus orderStatus
) {

    public static CreateOrderResponse with(final CreateCommandOutput command) {
        return new CreateOrderResponse(
                command.id(),
                command.status()
        );
    }
}

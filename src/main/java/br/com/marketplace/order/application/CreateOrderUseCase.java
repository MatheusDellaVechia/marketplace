package br.com.marketplace.order.application;

import br.com.marketplace.order.domain.customer.CustomerID;
import br.com.marketplace.order.domain.order.purchase.Order;
import br.com.marketplace.order.domain.order.purchase.OrderGateway;
import br.com.marketplace.order.domain.product.ProductID;
import br.com.marketplace.shared.application.UseCase;
import br.com.marketplace.shared.application.UseCaseAnnotation;
import br.com.marketplace.shared.domain.EventService;

@UseCaseAnnotation
public class CreateOrderUseCase
        extends UseCase<CreateOrderCommand, CreateCommandOutput> {

    private final OrderGateway orderGateway;
    private final EventService eventService;

    public CreateOrderUseCase(OrderGateway orderGateway, EventService eventService) {
        this.orderGateway = orderGateway;
        this.eventService = eventService;
    }

    @Override
    public CreateCommandOutput execute(CreateOrderCommand input) {
        final var customerId = CustomerID.from(input.customerId());
        final var productId = ProductID.with(input.productId());
        final var order = Order.create(
                customerId,
                productId,
                input.quantity()
        );
        final var saved = orderGateway.save(order);
        return CreateCommandOutput.with(saved);
    }
}

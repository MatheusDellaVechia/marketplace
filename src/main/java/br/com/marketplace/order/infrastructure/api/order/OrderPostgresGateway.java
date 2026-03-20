package br.com.marketplace.order.infrastructure.api.order;

import br.com.marketplace.order.domain.order.purchase.Order;
import br.com.marketplace.order.domain.order.purchase.OrderGateway;
import br.com.marketplace.order.infrastructure.api.order.persistence.OrderEntity;
import br.com.marketplace.order.infrastructure.api.order.persistence.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderPostgresGateway implements OrderGateway {

    private final OrderRepository orderRepository;

    public OrderPostgresGateway(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(OrderEntity.fromDomain(order))
                .toAggregate();
    }
}

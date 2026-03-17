package br.com.marketplace.order.infrastructure;

import br.com.marketplace.order.domain.order.purchase.Order;
import br.com.marketplace.order.domain.order.purchase.OrderGateway;
import org.springframework.stereotype.Service;

@Service
public class OrderGatewayImpl implements OrderGateway {

    @Override
    public Order save(Order order) {
        return null;
    }
}

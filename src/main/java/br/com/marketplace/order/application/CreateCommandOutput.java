package br.com.marketplace.order.application;

import br.com.marketplace.order.domain.order.purchase.Order;
import br.com.marketplace.order.domain.order.purchase.OrderStatus;

public record CreateCommandOutput(Long id, OrderStatus status) {

     public static CreateCommandOutput with(final Order order) {
          return new CreateCommandOutput(order.getId().getValue(), order.getStatus());
     }
}

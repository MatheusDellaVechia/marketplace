package br.com.marketplace.order.application;

import br.com.marketplace.order.domain.order.purchase.Order;

public record CreateCommandOutput(Long id) {

     public static CreateCommandOutput with(final Order order) {
          return new CreateCommandOutput(order.getId().getValue());
     }
}

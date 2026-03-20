package br.com.marketplace.order.infrastructure.api.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository<OrderEntity, Long> {
}

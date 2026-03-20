package br.com.marketplace.order.infrastructure.api.order.persistence;

import br.com.marketplace.order.domain.customer.CustomerID;
import br.com.marketplace.order.domain.order.purchase.Order;
import br.com.marketplace.order.domain.order.purchase.OrderStatus;
import br.com.marketplace.order.domain.product.ProductID;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "Order")
@Table(name = "orders")
public class OrderEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @Id
    private Long id;

    @NotNull
    @Column(name = "customer_id")
    private Long customerId;

    @NotNull
    @Column(name = "product_id")
    private Long productId;

    @NotNull
    @Column(name = "quantity")
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull(message = "Status não pode ser nulo")
    private OrderStatus status;

    public OrderEntity(Long customerId, Long productId, Integer quantity, OrderStatus status) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }

    public OrderEntity() {}

    public static OrderEntity fromDomain(final Order order) {
        return new OrderEntity(
                order.getCustomerId().getValue(),
                order.getProductId().getValue(),
                order.getQuantity(),
                order.getStatus()
        );
    }

    public Order toAggregate() {
        return Order.with(
                CustomerID.from(this.customerId),
                ProductID.from(this.productId),
                this.quantity,
                this.status
        );
    }
}

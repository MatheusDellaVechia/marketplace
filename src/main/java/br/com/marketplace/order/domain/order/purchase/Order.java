package br.com.marketplace.order.domain.order.purchase;

import br.com.marketplace.order.domain.customer.CustomerID;
import br.com.marketplace.order.domain.product.ProductID;
import br.com.marketplace.shared.domain.tactical_ddd.AggregateRoot;

public class Order extends AggregateRoot<OrderID> {

    private final CustomerID customerId;
    private final ProductID productId;
    private final Integer quantity;
    private final OrderStatus status;

    public Order(OrderID id, CustomerID customerId, ProductID productId, Integer quantity, OrderStatus status) {
        super(id);
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        super.registerEvent(OrderCreatedEvent.from(this));
    }

    public static Order create(CustomerID customerId, ProductID productId, Integer quantity) {
        return new Order(null, customerId, productId, quantity, OrderStatus.PENDING);
    }

    public CustomerID getCustomerId() {
        return customerId;
    }

    public ProductID getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderStatus getStatus() {return status;}
}

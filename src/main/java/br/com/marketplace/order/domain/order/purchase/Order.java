package br.com.marketplace.order.domain.order.purchase;

import br.com.marketplace.order.domain.customer.CustomerID;
import br.com.marketplace.order.domain.product.ProductID;
import br.com.marketplace.shared.domain.exceptions.DomainException;
import br.com.marketplace.shared.domain.tactical_ddd.AggregateRoot;

public class Order extends AggregateRoot<OrderID> {

    private final CustomerID customerId;
    private final ProductID productId;
    private final Integer quantity;
    private final OrderStatus status;

    private Order(OrderID id, CustomerID customerId, ProductID productId, Integer quantity, OrderStatus status) {
        super(id);
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        super.registerEvent(OrderCreatedEvent.from(this));
        this.validate(this);
    }

    private void validate(Order order) {
        if (order.getCustomerId() == null) {
            throw new DomainException("Customer Id cannot be null");
        }

        if (order.getProductId() == null) {
            throw new DomainException("Product Id cannot be null");
        }

        if (order.getQuantity() <= 0) {
            throw new DomainException("Invalid value for quantity informed");
        }
    }

    public static Order create(CustomerID customerId, ProductID productId, Integer quantity) {
        return new Order(null, customerId, productId, quantity, OrderStatus.PENDING);
    }

    public static Order with(CustomerID customerId, ProductID productId, Integer quantity, OrderStatus status) {
        return new Order(null, customerId, productId, quantity, status);
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

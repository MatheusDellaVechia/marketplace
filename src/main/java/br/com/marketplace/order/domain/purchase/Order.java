package br.com.marketplace.order.domain.purchase;

import br.com.marketplace.order.domain.customer.CustomerID;
import br.com.marketplace.order.domain.product.ProductID;
import br.com.marketplace.shared.domain.AggregateRoot;

public class Order extends AggregateRoot<OrderID> {

    private final CustomerID customerId;
    private final ProductID productId;
    private final Integer quantity;

    public Order(OrderID id, CustomerID customerId, ProductID productId, Integer quantity) {
        super(id);
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
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
}

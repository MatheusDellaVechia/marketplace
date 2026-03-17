package br.com.marketplace.order.domain.product;

import br.com.marketplace.order.domain.value_objects.Price;
import br.com.marketplace.order.domain.value_objects.SKU;
import br.com.marketplace.shared.domain.tactical_ddd.Entity;

public class Product extends Entity<ProductID> {

    private final String description;
    private final Price price;
    private final SKU sku;

    protected Product(ProductID id, String description, Price price, SKU sku) {
        super(id);
        this.description = description;
        this.price = price;
        this.sku = sku;
    }
}

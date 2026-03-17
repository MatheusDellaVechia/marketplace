package br.com.marketplace.order.domain.customer;

import br.com.marketplace.order.domain.value_objects.CustomerName;
import br.com.marketplace.order.domain.value_objects.TaxID;
import br.com.marketplace.shared.domain.tactical_ddd.Entity;

public class Customer extends Entity<CustomerID> {

    private final CustomerName name;
    private final TaxID taxID;

    protected Customer(CustomerID id, CustomerName name, TaxID taxID) {
        super(id);
        this.name = name;
        this.taxID = taxID;
    }
}

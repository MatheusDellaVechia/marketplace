package br.com.marketplace.order.infrastructure.api;

import br.com.marketplace.order.application.CreateOrderCommand;
import br.com.marketplace.order.application.CreateOrderUseCase;
import br.com.marketplace.order.infrastructure.api.order.models.CreateOrderRequest;
import br.com.marketplace.order.infrastructure.api.order.models.CreateOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> create(@RequestBody CreateOrderRequest request) {
        final var command = CreateOrderCommand.with(
                request.customerId(),
                request.productId(),
                request.quantity()
        );
        final var output = createOrderUseCase.execute(command);
        final var response = CreateOrderResponse.with(output);

        final var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(output.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }
}

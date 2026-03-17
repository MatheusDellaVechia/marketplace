package br.com.marketplace.shared.domain.tactical_ddd;

import java.time.Instant;

public interface DomainEvent {

    Instant occurredOn();

}

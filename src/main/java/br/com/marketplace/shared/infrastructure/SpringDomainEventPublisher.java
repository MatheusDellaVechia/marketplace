package br.com.marketplace.shared.infrastructure;

import br.com.marketplace.shared.domain.EventService;
import br.com.marketplace.shared.domain.tactical_ddd.DomainEvent;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpringDomainEventPublisher implements EventService {

    private static final Logger log = LoggerFactory.getLogger(SpringDomainEventPublisher.class);
    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringDomainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public void publish(Object event) {
        log.info("Publicando evento: {} para os listeners.", event.getClass().getSimpleName());
        this.applicationEventPublisher.publishEvent(event);
    }
}
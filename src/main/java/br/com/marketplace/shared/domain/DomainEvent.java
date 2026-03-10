package br.com.marketplace.shared.domain;

public interface DomainEvent {

    void publish(final Object event);

}

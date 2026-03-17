package br.com.marketplace.shared.domain;

public interface EventService {

    void publish(Object event);
}

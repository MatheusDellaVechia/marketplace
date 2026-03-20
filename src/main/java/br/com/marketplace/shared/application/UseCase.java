package br.com.marketplace.shared.application;

import org.springframework.modulith.NamedInterface;

@NamedInterface
public abstract class UseCase<I, O> {

    public abstract O execute(final I input);

}

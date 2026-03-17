package br.com.marketplace.shared.application;

public abstract class UseCase<I, O> {

    public abstract O execute(final I input);

}

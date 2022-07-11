package ir.hotel.repository.Impl;

import ir.hotel.repository.ServiceDecorator;

public abstract class ServiceDecoratorImpl implements ServiceDecorator {

    protected ServiceDecorator service;

    protected boolean selected;

    public ServiceDecoratorImpl(ServiceDecorator service) {
        this.service = service;
    }

    @Override
    public int amount() {
        return service.amount();
    }

}

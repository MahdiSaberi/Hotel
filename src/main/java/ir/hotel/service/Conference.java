package ir.hotel.service;

import ir.hotel.repository.Impl.ServiceDecoratorImpl;
import ir.hotel.repository.ServiceDecorator;

public class Conference extends ServiceDecoratorImpl {

    public Conference(ServiceDecorator service) {
        super(service);
    }

    @Override
    public int amount() {
        return service.amount() + 250;
    }
}

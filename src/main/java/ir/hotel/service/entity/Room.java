package ir.hotel.service.entity;

import ir.hotel.repository.Impl.ServiceDecoratorImpl;
import ir.hotel.repository.ServiceDecorator;

public class Room extends ServiceDecoratorImpl {

    public Room(ServiceDecorator service) {
        super(service);
    }

    @Override
    public int amount() {
        return service.amount() + 500;
    }
}

package ir.hotel.service.entity;

import ir.hotel.repository.ServiceDecorator;

public class NullService implements ServiceDecorator {
    @Override
    public int amount() {
        return 0;
    }

}

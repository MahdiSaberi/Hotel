package ir.hotel.service;

import ir.hotel.repository.ServiceDecorator;

public class BaseService implements ServiceDecorator {
    @Override
    public int amount() {
        return 0;
    }

}
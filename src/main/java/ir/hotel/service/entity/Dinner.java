package ir.hotel.service.entity;

import ir.hotel.repository.Impl.ServiceDecoratorImpl;
import ir.hotel.repository.ServiceDecorator;

public class Dinner extends ServiceDecoratorImpl {

    public Dinner(ServiceDecorator service) {
        super(service);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public int amount() {
        return service.amount() + 100;
    }


}

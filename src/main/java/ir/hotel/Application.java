package ir.hotel;

import ir.hotel.entity.Customer;
import ir.hotel.repository.ServiceDecorator;
import ir.hotel.service.BaseService;
import ir.hotel.service.Dinner;
import ir.hotel.service.Room;
import ir.hotel.util.Menu;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Menu.firstMenu();
    }
}

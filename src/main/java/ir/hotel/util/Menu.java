package ir.hotel.util;

import ir.hotel.entity.Customer;
import ir.hotel.repository.ServiceDecorator;
import ir.hotel.service.BaseService;
import ir.hotel.service.Conference;
import ir.hotel.service.Dinner;
import ir.hotel.service.Room;
import org.w3c.dom.Node;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Menu {

    private static Customer customer = new Customer();
    private static Set<ServiceDecorator> serviceDecoratorList = new HashSet<>();

    public static void firstMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================");
        System.out.println("1.Add Service for Customer\n2.Service List\n3.Exit");
        System.out.println("==================");

        int choose = 0;

        try{
            choose = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Enter valid number");
            firstMenu();
        }

        switch (choose) {
            case 1:
                addCustomer();
                addService();
                break;

            case 2:
                serviceList();
                break;

            case 3:
                System.exit(0);
        }

    }

    private static void serviceList() throws IOException {
        System.out.println("==================");
        System.out.print("Service List:");
        Operation.serviceList();
        System.out.println("\n==================");
        firstMenu();
    }

    private static void addService() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================");
        System.out.println("Select Services:");
        System.out.println("1.Room\n2.Conference\n3.Dinner\n4.Submit\n0.Back");

        int choose = 0;

        try{
            choose = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Enter valid number");
            addService();
        }

        switch (choose) {
            case 0:
                firstMenu();
                break;

            case 1:
                customer.setServiceDecorator(new Room(new BaseService()));
                System.out.println("Done!");
                serviceDecoratorList.add(new Room(new BaseService()));
                addService();
                break;

            case 2:
                customer.setServiceDecorator(new Conference(new BaseService()));
                System.out.println("Done!");
                serviceDecoratorList.add(new Conference(new BaseService()));
                addService();
                break;

            case 3:
                customer.setServiceDecorator(new Dinner(new BaseService()));
                System.out.println("Done!");
                serviceDecoratorList.add(new Dinner(new BaseService()));
                addService();
                break;

            case 4:
                Operation.inputOperation(serviceDecoratorList,customer);
                System.out.println("Submitted!");
                firstMenu();
        }


    }
    public static void addCustomer(){
        serviceDecoratorList = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================");
        System.out.println("Customer:");

        System.out.println("Enter FirstName:");
        String firstName = scanner.nextLine();

        System.out.println("Enter lastName:");
        String lastName = scanner.nextLine();

        System.out.println("Enter ID:");
        Long id = scanner.nextLong();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setId(id);
    }
}

package ir.hotel.entity;

import ir.hotel.repository.ServiceDecorator;

public class Customer extends BaseEntity{
    private String firstName;

    private String lastName;

    private ServiceDecorator serviceDecorator;

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ServiceDecorator getServiceDecorator() {
        return serviceDecorator;
    }

    public void setServiceDecorator(ServiceDecorator serviceDecorator) {
        this.serviceDecorator = serviceDecorator;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", serviceDecorator=" + serviceDecorator +
                '}';
    }
}

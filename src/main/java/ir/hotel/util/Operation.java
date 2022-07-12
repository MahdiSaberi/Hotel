package ir.hotel.util;

import ir.hotel.entity.Customer;
import ir.hotel.repository.ServiceDecorator;

import java.io.*;
import java.nio.file.Files;
import java.util.Set;

public class Operation {


    public static void inputOperation(Set<ServiceDecorator> serviceDecoratorList, Customer customer) throws IOException {
        String serviceList= "";
        String serviceName = "";
        int index;

        for(ServiceDecorator l : serviceDecoratorList){
            serviceName = l.getClass().getName();
            index = serviceName.lastIndexOf(".");
            serviceName = serviceName.substring(index+1);
            serviceList = serviceList.concat(serviceName+";");
        }
//        String serviceName = serviceDecoratorList.getClass().getName();
//        int idx = serviceName.lastIndexOf(".");
//        serviceName = serviceName.substring(idx+1);

        File file = new File("data.txt");

        if(file.exists()) {
            File updated = new File("updated.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            FileWriter fileWriter = new FileWriter(updated);
            int s;

            while ((s = fileInputStream.read()) != -1){
                fileWriter.write((char) s);
            }
            System.out.println("serviceList: "+serviceList);

            int amount = 0;
            for(ServiceDecorator sd : serviceDecoratorList)
                amount = amount + sd.amount();

            fileWriter.append("\n"+customer.getFirstName()+";"+customer.getLastName()+";"+serviceList+amount);
            fileInputStream.close();
            fileWriter.close();
            Files.delete(file.toPath());
            updated.renameTo(new File("data.txt"));
        }

        else if(!file.exists()){
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(customer.getFirstName()+";"+customer.getLastName()+";"+serviceName+";"+customer.getServiceDecorator().amount());
            fileWriter.close();
        }

    }

    public static void serviceList() throws IOException {
        File file = new File("data.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        int s;
        while ((s = fileInputStream.read()) != -1){
            if((char) s == ';')
                System.out.print(" ");
            else
                System.out.print((char) s);
        }
    }
}

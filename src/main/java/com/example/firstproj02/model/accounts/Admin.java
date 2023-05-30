package com.example.firstproj02.model.accounts;

import com.example.firstproj02.model.processes.Request;
import com.example.firstproj02.model.products.*;

import java.util.ArrayList;

public class Admin extends User {
    public static Admin admin;
    private final ArrayList<Product> products;
    private final ArrayList<Request> requests;

    private Admin(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
        products = new ArrayList<>();

        FlashMemory flashMemory1=new FlashMemory(2.0, 12,12,"12:12:12", "name0", 10, 90);
        FlashMemory flashMemory2=new FlashMemory(2.0, 12,12,"12:12:12", "nasdfme1", 10, 90);        FlashMemory flashMemory=new FlashMemory(2.0, 12,12,"12:12:12", "name", 10, 90);
        FlashMemory flashMemory3=new FlashMemory(2.0, 12,12,"12:12:12", "name2jkfd", 10, 90);

        Car car=new Car(90, true, "djfk", "jdkfj", 90, 90);

        NoteBook noteBook=new NoteBook(90, "jdkfj", "kdlf", "kdlf", 90, 90);

        EdibleProduct edibleProduct=new EdibleProduct("12", "2", "ddf", 90, 90);

        products.add(flashMemory3);
        products.add(flashMemory2);
        products.add(flashMemory1);
        products.add(car);
        products.add(noteBook);
        products.add(edibleProduct);


        requests = new ArrayList<>();
    }

    public static Admin getInstance(String userName, String email, String phoneNumber, String password) {
        if (admin == null) admin = new Admin(userName, email, phoneNumber, password);
        return admin;
    }

    public static Admin getAdmin() {
        return admin;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

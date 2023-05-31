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

        FlashMemory flashMemoryB=new FlashMemory(2.0, 12,12,"12:12:12", "flash memory b", 10, 90);
        FlashMemory flashMemoryA=new FlashMemory(2.0, 12,12,"12:12:12", "flash memory a", 10, 90);        FlashMemory flashMemory=new FlashMemory(2.0, 12,12,"12:12:12", "name", 10, 90);
        FlashMemory flashMemoryC=new FlashMemory(2.0, 12,12,"12:12:12", "flash memory c", 10, 90);

        Car car=new Car(90, true, "Iran", "car", 90, 90);

        NoteBook noteBook=new NoteBook(90, "Iran", "Iran", "note book", 90, 90);

        EdibleProduct edibleProduct=new EdibleProduct("12", "2", "edibel product", 90, 90);

        products.add(flashMemoryB);
        products.add(flashMemoryC);
        products.add(flashMemoryA);
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

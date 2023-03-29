package model.user;

import model.product.Product;

import java.util.ArrayList;

public class Admin extends User {
    public static Admin admin;
    private final ArrayList<Product> products;
    private final ArrayList<Request> requests;

    private Admin(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
        products = new ArrayList<>();
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

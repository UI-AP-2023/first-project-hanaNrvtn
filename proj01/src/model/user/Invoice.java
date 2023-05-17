package model.user;

import model.product.Product;

import java.util.ArrayList;

public class Invoice {
    static int counter;
    private final String ID;
    private final String date;
    private final int totalAmount;
    private final ArrayList<Product> boughtProducts;

    public Invoice(String date, ArrayList<Product> boughtProducts) {
        ++counter;
        this.date = date;
        this.boughtProducts = boughtProducts;
        this.totalAmount = calculateTotalAmount();
        ID = IDMaker();
    }

    private String IDMaker() {
        return counter + date.split("-")[2] + date.split("-")[2];
    }

    private int calculateTotalAmount() {
        int totalAmount = 0;
        for (Product a : boughtProducts)
            totalAmount += a.getPrice();
        return totalAmount;
    }

    public String getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Product> getBoughtProducts() {
        return boughtProducts;
    }

    @Override
    public String toString() {
        StringBuilder boughtProduct = new StringBuilder();
        for (Product a : this.boughtProducts)
            boughtProduct.append("\nname: ").append(a.getName()).append("\nprice: ").append(a.getPrice());
        return "\nID: " + ID + "\ndate: " + date + "\ntotal amount: " + totalAmount + boughtProduct;
    }
}

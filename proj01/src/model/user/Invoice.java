package model.user;

import model.product.Product;

import java.util.ArrayList;

public class Invoice {
    private final String ID;
    private final String date;
    private final int totalAmount;
    private final ArrayList<Product> boughtProducts;

    public Invoice(String date, ArrayList<Product> boughtProducts) {
        ID = IDMaker();
        this.date = date;
        this.totalAmount = calculateTotalAmount();
        this.boughtProducts = boughtProducts;
    }

    private String IDMaker() {
        return "";
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

    public double getPayedAmount() {
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

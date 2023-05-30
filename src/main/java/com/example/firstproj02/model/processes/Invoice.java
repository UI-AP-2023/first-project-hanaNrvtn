package com.example.firstproj02.model.processes;

import com.example.firstproj02.model.products.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Invoice {
    static int counter;
    private final String ID;
    private final LocalDate date;
    private final ArrayList<Product> boughtProducts;
    private final ArrayList<DiscountCode> appliedDiscountCodes;
    private final double totalAmount;
    private double totalDiscount;
    private double finalAmount;

    public Invoice(LocalDate date, ArrayList<Product> boughtProducts) {
        ++counter;
        this.date = date;
        this.boughtProducts = boughtProducts;
        this.appliedDiscountCodes = new ArrayList<>();
        this.totalAmount = calculateTotalAmount();
        //this.totalDiscount = 0;
        this.finalAmount = totalAmount;
        ID = IDMaker();
    }

    private String IDMaker() {
        Random random=new Random();
        return date.toString().split("-")[0] + (char)random.nextInt(65, 91) +
                date.toString().split("-")[1] +
                (char)random.nextInt(97, 123) +
                date.toString().split("-")[2];
    }

    private double calculateTotalAmount() {
        double totalAmount = 0;
        for (Product a : boughtProducts)
            totalAmount += a.getPrice();
        return totalAmount;
    }

    /*
    public void setTotalDiscount() {
        double totalDiscount = 1;
        for (DiscountCode a : appliedDiscountCodes)
            totalDiscount *= a.getPercentage() * 0.01;
        this.totalDiscount = totalDiscount;
    }
     */

    public double updateFinalAmount(){
        finalAmount=totalAmount;
        appliedDiscountCodes.forEach(n->finalAmount*=(n.getPercentage()*0.01));
        return finalAmount;
    }

    /*
    private double calculateFinalAmount() {
        return this.totalAmount - (this.totalAmount * this.totalDiscount);
    }
     */

    public String getID() {
        return ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public ArrayList<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public ArrayList<DiscountCode> getAppliedDiscountCodes() {
        return appliedDiscountCodes;
    }

    public String toString1(){
        StringBuilder boughtProduct = new StringBuilder();
        for (Product a : this.boughtProducts)
            boughtProduct.append("\nname: ").append(a.getName()).append("\nID: ").append(a.getID());
        return "\nID: " + ID + "\ndate: " + date + "\ntotal amount: " + totalAmount + boughtProduct + "\nfinal amount: " + finalAmount + "\nproducts: " + boughtProduct;
    }

    @Override
    public String toString() {
        return "ID: " +this.ID + "    Date: " + this.date;
    }
}

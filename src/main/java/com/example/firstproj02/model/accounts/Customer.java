package com.example.firstproj02.model.accounts;

import com.example.firstproj02.model.processes.Invoice;
import com.example.firstproj02.model.processes.DiscountCode;
import com.example.firstproj02.model.products.Product;

import java.util.ArrayList;

public class Customer extends User {
    private final ArrayList<Product> Cart;
    private final ArrayList<Invoice> invoices;
    private final ArrayList<DiscountCode> discountCodes;
    private double credit;

    public Customer(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
        Cart = new ArrayList<>();
        invoices = new ArrayList<>();
        discountCodes = new ArrayList<>();
    }

    public ArrayList<Product> getCart() {
        return Cart;
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public ArrayList<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return super.toString() + "\ncredit: " + credit;
    }
}

package model.user;

import model.product.Product;

import java.util.ArrayList;

public class Customer extends User {
    private final ArrayList<Product> Cart;
    private ArrayList<Invoice> invoices;
    private double credit;

    public Customer(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
        Cart = new ArrayList<>();
        invoices = new ArrayList<>();
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public ArrayList<Product> getCart() {
        return Cart;
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return super.toString() + "\ncredit: " + credit;
    }
}

package com.example.firstproj02.model.processes;

import com.example.firstproj02.model.accounts.Customer;

public class IncreaseCreditRequest extends Request {
    private final Customer customer;
    private double additionalCredit;
    private String creditCardNumber;
    private String CVV2;
    private String password;

    public IncreaseCreditRequest(Customer customer, double additionalCredit, String creditCardNumber, String CVV2, String password) {
        super(RequestType.CREDIT_INCREASE_REQUEST);
        this.customer = customer;
        this.additionalCredit = additionalCredit;
        this.creditCardNumber = creditCardNumber;
        this.CVV2 = CVV2;
        this.password = password;
    }

    public double getAdditionalCredit() {
        return additionalCredit;
    }

    public void setAdditionalCredit(double additionalCredit) {
        this.additionalCredit = additionalCredit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCVV2() {
        return CVV2;
    }

    public void setCVV2(String CVV2) {
        this.CVV2 = CVV2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString1() {
        return super.toString() + "\nuser name:   " + customer.getUserName() + "\nadditional credit:   " + additionalCredit;
    }

    @Override
    public String toString() {
        return "CRD  ||  " + customer.getUserName();
    }
}

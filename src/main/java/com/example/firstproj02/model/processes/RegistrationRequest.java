package com.example.firstproj02.model.processes;

import com.example.firstproj02.model.accounts.Customer;

public class RegistrationRequest extends Request {
    private final Customer customer;

    public RegistrationRequest(Customer customer) {
        super(RequestType.REGISTRATION_REQUEST);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String toString1() {
        return super.toString() + "\nuser name:   " + customer.getUserName();
    }

    @Override
    public String toString() {
        return "REG  ||  " + customer.getUserName();
    }
}

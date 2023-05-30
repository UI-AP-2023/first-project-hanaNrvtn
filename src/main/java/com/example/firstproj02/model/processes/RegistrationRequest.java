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

    @Override
    public String toString() {
        return "user name: " + customer.getUserName() + super.toString();
    }
}

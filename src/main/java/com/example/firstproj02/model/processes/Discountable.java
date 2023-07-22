package com.example.firstproj02.model.processes;

public interface Discountable {
    void applyDiscount(double percentage, int capacity);

    void rescindDiscount();
}

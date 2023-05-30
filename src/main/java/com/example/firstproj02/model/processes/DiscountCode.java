package com.example.firstproj02.model.processes;

import java.time.LocalDate;
import java.util.Random;

public class DiscountCode {
    private double percentage;
    private LocalDate expiration;
    private int capacity;
    private final String code;
    private DiscountType discountType;

    public DiscountCode(double percentage, LocalDate expiration, int capacity, DiscountType discountType) {   //
        this.percentage = percentage;
        this.expiration = expiration;
        this.capacity = capacity;
        this.discountType = discountType;
        code = creatCode();
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public String getCode() {
        return code;
    }

    private String creatCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder(discountType.toString().substring(0, 4));
        for (int i = 0; i < 10; ++i) {
            switch (random.nextInt(1, 4)) {
                case 1 -> code.append((char) random.nextInt(65, 91));
                case 2 -> code.append((char) random.nextInt(97, 123));
                case 3 -> code.append(random.nextInt(0, 10));
            }
        }
        return code.toString();
    }

    @Override
    public String toString() {
        return "coupon code: " + this.code;
    }
}

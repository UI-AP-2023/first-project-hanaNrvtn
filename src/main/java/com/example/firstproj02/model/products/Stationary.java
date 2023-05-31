package com.example.firstproj02.model.products;

abstract public class Stationary extends Product {
    private String manufacturingCountry;

    public Stationary(String manufacturingCountry, String name, int price, int numberOfNewProduct) {
        super(ProductCategory.STATIONERY, name, price, numberOfNewProduct);
        this.manufacturingCountry = manufacturingCountry;
    }

    public String getManufacturingCountry() {
        return manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

    public String toString1() {
        return "manufacturer: " + manufacturingCountry + super.toString1();
    }
    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}

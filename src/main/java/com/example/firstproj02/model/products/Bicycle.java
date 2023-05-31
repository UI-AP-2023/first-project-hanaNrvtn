package com.example.firstproj02.model.products;

public class Bicycle extends Vehicle {
    private BikeType type;

    public Bicycle(String type, String manufacturer, String name, int price, int numberOfNewProduct) {
        super(manufacturer, name, price, numberOfNewProduct);
        this.type = BikeType.valueOf(type.toUpperCase());
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    public String toString1() {
        return "type: " + type.toString().toLowerCase() + super.toString1();
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}

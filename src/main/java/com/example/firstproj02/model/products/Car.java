package com.example.firstproj02.model.products;

public class Car extends Vehicle {
    private int motorCapacity;
    private boolean isAutomatic;

    public Car(int motorCapacity, boolean isAutomatic, String manufacturer, String name, int price, int numberOfNewProduct) {
        super(manufacturer, name, price, numberOfNewProduct);
        this.motorCapacity = motorCapacity;
        this.isAutomatic = isAutomatic;
    }

    public int getMotorCapacity() {
        return motorCapacity;
    }

    public void setMotorCapacity(int motorCapacity) {
        this.motorCapacity = motorCapacity;
    }

    public boolean getAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public String toString1() {
        return "motor capacity: " + motorCapacity + "\nautomatic: " + isAutomatic + super.toString1();
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}

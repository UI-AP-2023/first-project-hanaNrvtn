package com.example.firstproj02.model.products;

abstract public class DataStorageEquipment extends DigitalEquipment {
    private int capacity;

    public DataStorageEquipment(int capacity, double weight, String dimension, String name, int price, int numberOfProduct) {
        super(weight, dimension, name, price, numberOfProduct);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString1() {
        return "capacity: " + capacity + super.toString1();
    }
}

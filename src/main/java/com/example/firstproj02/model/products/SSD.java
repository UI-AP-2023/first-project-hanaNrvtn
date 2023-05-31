package com.example.firstproj02.model.products;

public class SSD extends DataStorageEquipment {
    private int writeSpeed;
    private int readSpeed;

    public SSD(int readSpeed, int writeSpeed, int capacity, double weight, String dimension, String name, int price, int numberOfProduct) {
        super(capacity, weight, dimension, name, price, numberOfProduct);
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }

    public int getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(int readSpeed) {
        this.readSpeed = readSpeed;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    public String toString1() {
        return "read speed: " + readSpeed + "\nwrite speed: " + writeSpeed + super.toString1();
    }
    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}

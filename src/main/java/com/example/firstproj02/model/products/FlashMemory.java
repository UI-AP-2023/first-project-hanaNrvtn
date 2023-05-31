package com.example.firstproj02.model.products;

public class FlashMemory extends DataStorageEquipment {
    private double USBVersion;

    public FlashMemory(double USBVersion, int capacity, double weight, String dimension, String name, int price, int numberOfProduct) {
        super(capacity, weight, dimension, name, price, numberOfProduct);
        this.USBVersion = USBVersion;
    }

    public double getUSBVersion() {
        return USBVersion;
    }

    public void setUSBVersion(double USBVersion) {
        this.USBVersion = USBVersion;
    }

    public String toString1() {
        return "USB version: " + USBVersion + super.toString1();
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}

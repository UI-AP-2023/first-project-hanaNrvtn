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

    /*
    @Override
    public int compareTo(FlashMemory flashMemory){
        if(flashMemory.getUSBVersion()>this.getUSBVersion()) return 1;
        else if(flashMemory.getUSBVersion()<this.getUSBVersion()) return -1;
        else {
            if(flashMemory.getWeight()>this.getWeight()) return 1;
            else if(flashMemory.getWeight()<this.getWeight()) return -1;
            else return
        }
    }
     */

    @Override
    public String toString() {
        return "\nUSB version: " + USBVersion + super.toString();
    }
}

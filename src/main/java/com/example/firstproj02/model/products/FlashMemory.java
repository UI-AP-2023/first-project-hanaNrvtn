package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Comment;

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
        StringBuilder comments=new StringBuilder();
        for(Comment a: getComments())
            comments.append("\n").append(a.getUser().getUserName()).append("\n").append(a.getText()).append("\n=-=-=-=-=-=-=-=-=-=-=-=");
        return super.getName() + "\nUSB version:  " + this.getUSBVersion() + "\nweight:  " + super.getWeight() + "\ndimension:  " + super.getDimension() + "\nprice:  " + super.getPrice() + "$\nstatus:  " + super.getAvailable() + "\nscore:  " + String.format("%.2f", super.getScore()) + "\n=-=-=-=-=-=-=-=-=-=-=-=\n comments: " + comments;
    }
}

package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Comment;

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
        StringBuilder comments = new StringBuilder();
        for (Comment a : getComments())
            comments.append("\n").append(a.getUser().getUserName()).append("\n").append(a.getText()).append("\n=-=-=-=-=-=-=-=-=-=-=-=");
        return super.getName() + "\nread speed:  " + "\ncapacity:  " + super.getCapacity() + this.readSpeed + "\nwrite speed:  " + this.writeSpeed + "\nweight:  " + super.getWeight() + "\ndimension:  " + super.getDimension() + "\nprice:  " + super.getPrice() + "$\nstatus:  " + super.getAvailable() + "\nscore:  " + String.format("%.2f", super.getScore()) + "\n=-=-=-=-=-=-=-=-=-=-=-=\n comments: " + comments;
    }
}

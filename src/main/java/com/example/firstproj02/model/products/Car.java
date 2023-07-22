package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Comment;

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
        StringBuilder comments = new StringBuilder();
        for (Comment a : getComments())
            comments.append("\n").append(a.getUser().getUserName()).append("\n").append(a.getText()).append("\n=-=-=-=-=-=-=-=-=-=-=-=");
        return super.getName() + "\nmotor capacity:  " + this.motorCapacity + "cc" + "\nautomatic:  " + this.isAutomatic + "\nproduced by:  " + super.getManufacturer() + "\nprice:  " + super.getPrice() + "$\nstatus:  " + super.getAvailable() + "\nscore:  " + String.format("%.2f", super.getScore()) + "\n=-=-=-=-=-=-=-=-=-=-=-=\n comments: " + comments;
    }
}

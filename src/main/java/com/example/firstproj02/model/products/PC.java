package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Comment;

public class PC extends DigitalEquipment {
    private String CPUModel;
    private int RAMCapacity;

    public PC(String CPUModel, int RAMCapacity, double weight, String dimension, String name, int price, int numberOfProduct) {
        super(weight, dimension, name, price, numberOfProduct);
        this.CPUModel = CPUModel;
        this.RAMCapacity = RAMCapacity;
    }

    public String getCPUModel() {
        return CPUModel;
    }

    public void setCPUModel(String CPUModel) {
        this.CPUModel = CPUModel;
    }

    public int getRAMCapacity() {
        return RAMCapacity;
    }

    public void setRAMCapacity(int RAMCapacity) {
        this.RAMCapacity = RAMCapacity;
    }

    public String toString1() {
        StringBuilder comments = new StringBuilder();
        for (Comment a : getComments())
            comments.append("\n").append(a.getUser().getUserName()).append("\n").append(a.getText()).append("\n=-=-=-=-=-=-=-=-=-=-=-=");
        return super.getName() + "\nCPU:  " + this.CPUModel + "\nRAM:  " + this.RAMCapacity + "\nweight:  " + super.getWeight() + "\ndimension:  " + super.getDimension() + "\nprice:  " + super.getPrice() + "$\nstatus:  " + super.getAvailable() + "\nscore:  " + String.format("%.2f", super.getScore()) + "\n=-=-=-=-=-=-=-=-=-=-=-=\n comments: " + comments;
    }
}
package com.example.firstproj02.model.products;

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

    /*
    @Override
    public int compareTo(PC pc){
        if(this.getCPUModel().compareTo(pc.getCPUModel())>0)
            return 1;
        if(this.getCPUModel().compareTo(pc.getCPUModel())<0)
            return -1;
        else{
            if(pc.getRAMCapacity()>this.getRAMCapacity())
                return 1;
            else if(pc.getRAMCapacity()<this.getRAMCapacity())
                return -1;
            else return ;
        }

    }
     */

    @Override
    public String toString() {
        return "\nCPU model: " + CPUModel + "\nRAM capacity: " + RAMCapacity + super.toString();
    }
}
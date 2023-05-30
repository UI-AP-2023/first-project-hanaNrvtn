package com.example.firstproj02.model.products;

abstract public class DataStorageEquipment extends DigitalEquipment implements Comparable<Product>{
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

    @Override
    public int compareTo(Product product){
        DataStorageEquipment dataStorageEquipment=(DataStorageEquipment) product;
        if((dataStorageEquipment instanceof SSD) && !(this instanceof SSD)) return 1;
        else if(!(dataStorageEquipment instanceof SSD) && (this instanceof SSD)) return -1;
        else if(dataStorageEquipment instanceof SSD) return ((SSD)dataStorageEquipment).compareTo((SSD) this);
        else return this.compareTo(dataStorageEquipment);
    }


    @Override
    public String toString() {
        return "\ncapacity: " + capacity + super.toString();
    }
}

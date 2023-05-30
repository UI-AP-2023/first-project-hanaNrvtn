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

    /*
    @Override
    public int compareTo(SSD ssd){
        if(ssd.readSpeed>this.readSpeed) return 1;
        else if(ssd.readSpeed<this.readSpeed) return -1;
        else {
            if(ssd.writeSpeed>this.writeSpeed) return 1;
            else if(ssd.writeSpeed<this.writeSpeed) return -1;
            else{
                if(ssd.getWeight()>this.getWeight()) return 1;
                else if(ssd.getWeight()<this.getWeight()) return -1;
                else return 0;
            }
        }
    }
     */
    @Override
    public String toString() {
        return "\nread speed: " + readSpeed + "\nwrite speed: " + writeSpeed + super.toString();
    }
}

package model.product;

public class SSD extends DataStorageEquipment {
    private int writeSpeed;
    private int readSpeed;

    public SSD(String category, String name, int price, int numberOfSupply, double weight, String dimension, int capacity, int readSpeed, int writeSpeed) {
        super(category, name, price, numberOfSupply, weight, dimension, capacity);
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

    @Override
    public String toString() {
        return super.toString() + "\nread speed: " + readSpeed + "\nwrite speed: " + writeSpeed;
    }
}

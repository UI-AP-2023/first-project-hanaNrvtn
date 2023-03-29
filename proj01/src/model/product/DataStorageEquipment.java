package model.product;

abstract public class DataStorageEquipment extends DigitalEquipment {
    private int capacity;

    public DataStorageEquipment(String category, String name, int price, int numberOfSupply, double weight, String dimension, int capacity) {
        super(category, name, price, numberOfSupply, weight, dimension);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\ncapacity: " + capacity;
    }
}

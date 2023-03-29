package model.product;

public class FlashMemory extends DataStorageEquipment {
    private double USBVersion;  //

    public FlashMemory(String category, String name, int price, int numberOfSupply, double weight, String dimension, int capacity, double USBVersion) {
        super(category, name, price, numberOfSupply, weight, dimension, capacity);
        this.USBVersion = USBVersion;
    }

    public double getUSBVersion() {
        return USBVersion;
    }

    public void setUSBVersion(double USBVersion) {
        this.USBVersion = USBVersion;
    }

    @Override
    public String toString() {
        return super.toString() + "\nUSB version: " + USBVersion;
    }
}

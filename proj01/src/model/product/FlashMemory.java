package model.product;

public class FlashMemory extends DataStorageEquipment {
    private double USBVersion;  //

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

    @Override
    public String toString() {
        return "\nUSB version: " + USBVersion + super.toString();
    }
}

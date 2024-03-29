package model.product;

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

    @Override
    public String toString() {
        return "\nmotor capacity: " + motorCapacity + "\nautomatic: " + isAutomatic + super.toString();
    }
}

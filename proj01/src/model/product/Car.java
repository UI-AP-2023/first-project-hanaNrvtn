package model.product;

public class Car extends Vehicle {
    private int motorCapacity;
    private boolean isAutomatic;

    public Car(String category, String name, int price, int numberOfSupply, String manufacturer, int motorCapacity, boolean isAutomatic) {
        super(category, name, price, numberOfSupply, manufacturer);
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
        return super.toString() + "\nmotor capacity: " + motorCapacity + "\nautomatic: " + isAutomatic;
    }
}

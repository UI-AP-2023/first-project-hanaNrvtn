package model.product;

public class Vehicle extends Product {
    private String manufacturer;

    public Vehicle(String category, String name, int price, int numberOfSupply, String manufacturer) {
        super(category, name, price, numberOfSupply);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return super.toString() + "\nmanufacturer: " + manufacturer;
    }
}

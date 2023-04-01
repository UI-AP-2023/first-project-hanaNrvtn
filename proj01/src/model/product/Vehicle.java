package model.product;

abstract public class Vehicle extends Product {
    private String manufacturer;

    public Vehicle(String manufacturer, String name, int price, int numberOfNewProduct) {
        super(ProductCategory.VEHICLE, name, price, numberOfNewProduct);
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
        return "\nmanufacturer: " + manufacturer + super.toString();
    }
}

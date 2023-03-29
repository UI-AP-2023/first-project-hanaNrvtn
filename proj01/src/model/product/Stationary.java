package model.product;

public class Stationary extends Product {
    private String manufacturingCountry;

    public Stationary(String category, String name, int price, int numberOfSupply, String manufacturingCountry) {
        super(category, name, price, numberOfSupply);
        this.manufacturingCountry = manufacturingCountry;
    }

    public String getManufacturingCountry() {
        return manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

    @Override
    public String toString() {
        return super.toString() + "\nmanufacturer: " + manufacturingCountry;
    }
}

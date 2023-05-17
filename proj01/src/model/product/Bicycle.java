package model.product;

public class Bicycle extends Vehicle{
    private BikeType type;

    public Bicycle(String type, String manufacturer, String name, int price, int numberOfNewProduct) {
        super(manufacturer, name, price, numberOfNewProduct);
        this.type = BikeType.valueOf(type.toUpperCase());
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\ntype: " + type.toString().toLowerCase() + super.toString();
    }
}

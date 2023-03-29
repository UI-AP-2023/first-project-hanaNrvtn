package model.product;

public class Bicycle extends Vehicle {
    private BikeType type;

    public Bicycle(String category, String name, int price, int numberOfSupply, String manufacturer, String type) {
        super(category, name, price, numberOfSupply, manufacturer);
        this.type = BikeType.valueOf(type);
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "\ntype: " + type.toString().toLowerCase();
    }
}

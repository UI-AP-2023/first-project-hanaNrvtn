package model.product;

abstract public class DigitalEquipment extends Product {
    private double weight;
    private String dimension;

    public DigitalEquipment(String category, String name, int price, int numberOfSupply, double weight, String dimension) {
        super(category, name, price, numberOfSupply);
        this.weight = weight;
        this.dimension = dimension;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }


    @Override
    public String toString() {
        return super.toString() + "\nweight: " + weight + "\nlength: " + dimension.split(":")[0] + "\nwidth: " + dimension.split(":")[1] + "\nheight: " + dimension.split(":")[2];
    }
}


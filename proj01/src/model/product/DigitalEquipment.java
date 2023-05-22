package model.product;

abstract public class DigitalEquipment extends Product implements Comparable<Product>, Discountable{
    private double weight;
    private String dimension;
    private double discountPercentage;
    private int discountCapacity;

    public DigitalEquipment(double weight, String dimension, String name, int price, int numberOfProduct) {
        super(ProductCategory.DIGITAL_EQUIPMENT, name, price, numberOfProduct);
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

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountCapacity() {
        return discountCapacity;
    }

    public void setDiscountCapacity(int discountCapacity) {
        this.discountCapacity = discountCapacity;
    }

    @Override
    public int compareTo(Product product){
        DigitalEquipment digitalEquipment=(DigitalEquipment) product;
        if((digitalEquipment instanceof DataStorageEquipment) && !(this instanceof DataStorageEquipment))
            return 1;
        else if(!(digitalEquipment instanceof DataStorageEquipment) && (this instanceof DataStorageEquipment))
            return -1;
        else if (digitalEquipment instanceof DataStorageEquipment)
            return this.compareTo(digitalEquipment);
        else return 0;
    }

    @Override
    public void applyDiscount(double percentage, int capacity){
        this.discountPercentage=percentage;
        this.discountCapacity=capacity;
    }

    @Override
    public void rescindDiscount(){
        this.discountPercentage=0;
        this.discountCapacity=0;
    }

        @Override
    public String toString() {
        return "\nweight: " + weight + "\nlength: " + dimension.split(":")[0] + "\nwidth: " + dimension.split(":")[1] + "\nheight: " + dimension.split(":")[2] + super.toString();
    }
}


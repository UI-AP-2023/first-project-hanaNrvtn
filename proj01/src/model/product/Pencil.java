package model.product;

public class Pencil extends Stationary implements Discountable{
    private PencilType type;
    private double discountPercentage;
    private int discountCapacity;


    public Pencil(String type, String manufacturingCountry, String name, int price, int numberOfProduct) {
        super(manufacturingCountry, name, price, numberOfProduct);
        this.type = PencilType.valueOf(type);
    }

    public PencilType getType() {
        return type;
    }

    public void setType(PencilType type) {
        this.type = type;
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
        return "\npencil type: " + type.toString() + super.toString();
    }
}

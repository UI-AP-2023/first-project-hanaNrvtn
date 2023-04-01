package model.product;

public class Pen extends Stationary {
    private PenColor color;  //

    public Pen(String color, String manufacturingCountry, String name, int price, int numberOfNewProduct) {
        super(manufacturingCountry, name, price, numberOfNewProduct);
        this.color = PenColor.valueOf(color);
    }

    public PenColor getColor() {
        return color;
    }

    public void setColor(PenColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\ncolor: " + color.toString().toLowerCase() + super.toString();
    }
}

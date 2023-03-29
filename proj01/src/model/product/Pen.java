package model.product;

public class Pen extends Stationary {
    private PenColor color;  //

    public Pen(String category, String name, int price, int numberOfSupply, String manufacturingCountry, String color) {
        super(category, name, price, numberOfSupply, manufacturingCountry);
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
        return super.toString() + "\ncolor: " + color.toString().toLowerCase();
    }
}

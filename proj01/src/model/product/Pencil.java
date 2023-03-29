package model.product;

public class Pencil extends Stationary {
    private PencilType type;

    public Pencil(String category, String name, int price, int numberOfSupply, String manufacturingCountry, String type) {
        super(category, name, price, numberOfSupply, manufacturingCountry);
        this.type = PencilType.valueOf(type);
    }

    public PencilType getType() {
        return type;
    }

    public void setType(PencilType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "\npencil type: " + type.toString();
    }
}

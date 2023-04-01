package model.product;

public class Pencil extends Stationary {
    private PencilType type;

    public Pencil(String type,  String manufacturingCountry, String name, int price, int numberOfProduct) {
        super(manufacturingCountry, name, price, numberOfProduct);
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
        return "\npencil type: " + type.toString() + super.toString() ;
    }
}

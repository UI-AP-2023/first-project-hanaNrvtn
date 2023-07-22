package model.product;

public interface Discountable {
    void applyDiscount(double percentage, int capacity);
    void rescindDiscount();
}

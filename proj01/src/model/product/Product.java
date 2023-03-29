package model.product;

import java.util.ArrayList;

abstract public class Product {
    private final String ID;  //
    private String name;
    private int price;
    private int numberOfProduct;
    private boolean isInSupply;
    private double score;
    private final ProductCategory category;  //
    private final ArrayList<Comment> comments;

    public Product(String category, String name, int price, int numberOfProduct) {
        ID = IDMaker();
        this.category = ProductCategory.valueOf(category);
        this.name = name;
        this.price = price;
        this.numberOfProduct = numberOfProduct;
        isInSupply = numberOfProduct > 0;
        comments = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public boolean getIsInSupply() {
        return isInSupply;
    }

    public void setInSupply(boolean inSupply) {
        isInSupply = inSupply;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    private String IDMaker() {
        return "";
    }

    @Override
    public String toString() {
        return "\nID: " + ID + "\nname: " + name + "\ncategory: " + category + "\nprice: " + price + "\nsupply status: " + isInSupply + "\nscore: " + score;
    }
}

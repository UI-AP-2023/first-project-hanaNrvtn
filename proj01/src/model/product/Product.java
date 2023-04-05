package model.product;

import java.util.ArrayList;

abstract public class Product {
    static int productCounter;
    private final String ID;
    private String name;
    private int price;
    private int numberOfProduct;
    private boolean isAvailable;
    private double score;
    private final ProductCategory category;
    private final ArrayList<Comment> comments;
    private final ArrayList<Rate> rates;

    public Product(ProductCategory category, String name, int price, int numberOfProduct) {
        ++productCounter;
        this.category = category;
        this.name = name;
        this.price = price;
        this.numberOfProduct=numberOfProduct;
        isAvailable = numberOfProduct > 0;
        ID = IDMaker();
        comments = new ArrayList<>();
        rates=new ArrayList<>();
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

    public boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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
        return category.toString().substring(0, 3) + "-" + name + "-" + productCounter;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "\nID: " + ID + "\nname: " + name + "\ncategory: " + category.toString().toLowerCase() + "\nprice: " + price + "\nstatus: " + isAvailable + "\naverage score: " + score + "\ncomments: " + comments.toString();
    }
}

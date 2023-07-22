package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Comment;
import com.example.firstproj02.model.processes.Rate;

import java.util.ArrayList;

abstract public class Product implements Comparable<Product> {
    static int productCounter;
    private String ID;
    private String name;
    private double price;
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
        this.numberOfProduct = numberOfProduct;
        isAvailable = numberOfProduct > 0;
        ID = IDMaker();
        comments = new ArrayList<>();
        rates = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        ID = IDMaker();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
    public int compareTo(Product product) {
        if (name.compareTo(product.name) > 0)
            return 1;
        else if (name.compareTo(product.name) < 0)
            return -1;
        else {
            if (product.score > score)
                return 1;
            else if (product.score < score)
                return -1;
            else {
                if (product.price > price)
                    return 1;
                else if (product.price < price)
                    return -1;
                else {
                    return Integer.compare(product.numberOfProduct, numberOfProduct);
                }
            }
        }
    }

    private int compareName(Product product) {
        return Integer.compare(name.compareTo(product.name), 0);
    }

    public String toString1() {
        StringBuilder commentsStr = new StringBuilder();
        for (Comment a : comments)
            commentsStr.append(a).append("\n=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        return "ID: " + ID + "\nname: " + name + "\ncategory: " + category.toString().toLowerCase() + "\nprice: " + price + "\nstatus: " + isAvailable + "\naverage score: " + score + "\n=-=-=-=-=-=-=-=-=-=-=-=-=\ncomments: " + commentsStr;
    }

    @Override
    public String toString() {
        return this.getName() + "\n" + this.getPrice() + " $";
    }
}

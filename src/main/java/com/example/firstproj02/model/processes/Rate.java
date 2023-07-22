package com.example.firstproj02.model.processes;

import com.example.firstproj02.model.accounts.User;
import com.example.firstproj02.model.products.Product;

public class Rate {
    private final User user;
    private Product product;  // ID or product
    private double score;

    public Rate(User user, Product product, double score) {
        this.user = user;
        this.product = product;
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "\nuser: " + user.getUserName() + "\nproduct: " + product.getID() + "\nscore: " + score;
    }
}

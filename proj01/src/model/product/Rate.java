package model.product;

import model.user.User;

public class Rate {
    private final User user;
    private Product product;  // ID or product
    private int score;

    Rate(User user, Product product, int score) {
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

    public int getScore() {
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

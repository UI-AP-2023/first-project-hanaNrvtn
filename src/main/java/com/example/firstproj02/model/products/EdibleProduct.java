package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Comment;

public class EdibleProduct extends Product {
    private String productionDate;  //
    private String expirationDate;  //

    public EdibleProduct(String productionDate, String expirationDate, String name, int price, int numberOfNewProduct) {
        super(ProductCategory.EDIBLE_PRODUCT, name, price, numberOfNewProduct);
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String toString1() {
        StringBuilder comments = new StringBuilder();
        for (Comment a : getComments())
            comments.append("\n").append(a.getUser().getUserName()).append("\n").append(a.getText()).append("\n=-=-=-=-=-=-=-=-=-=-=-=");
        return super.getName() + "\nprd date:  " + this.productionDate + "\nexp date:  " + this.expirationDate + "\nprice:  " + super.getPrice() + "$\nstatus:  " + super.getAvailable() + "\nscore:  " + String.format("%.2f", super.getScore()) + "\n=-=-=-=-=-=-=-=-=-=-=-=\n comments: " + comments;
    }
}

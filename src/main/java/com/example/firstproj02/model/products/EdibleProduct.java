package com.example.firstproj02.model.products;

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
        return "production date: " + productionDate + "\nexpiration date: " + expirationDate + super.toString1();
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}

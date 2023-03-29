package model.product;

public class EdibleProduct extends Product {
    private String productionDate;  //
    private String expirationDate;  //

    public EdibleProduct(String category, String name, int price, int numberOfSupply, String productionDate, String expirationDate) {
        super(category, name, price, numberOfSupply);
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

    @Override
    public String toString() {
        return super.toString() + "\nproduction date: " + productionDate + "\nexpiration date: " + expirationDate;
    }
}

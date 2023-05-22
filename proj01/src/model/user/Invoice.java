package model.user;

import model.product.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {
    static int counter;
    private final String ID;
    private final LocalDate date;
    private final double totalAmount;
    private final double totalDiscount;
    private final double finalAmount;
    private final ArrayList<Product> boughtProducts;
    private final ArrayList<DiscountCode> appliedDiscountCodes;

    public Invoice(LocalDate date, ArrayList<Product> boughtProducts) {
        ++counter;
        this.date = date;
        this.boughtProducts = boughtProducts;
        this.appliedDiscountCodes=new ArrayList<>();
        this.totalAmount = calculateTotalAmount();
        this.totalDiscount=calculateTotalDiscount();
        this.finalAmount=calculateFinalAmount();
        ID = IDMaker();
    }

    private String IDMaker() {
        return counter + date.toString().split("-")[2] + date.toString().split("-")[2];
    }

    private double calculateTotalAmount() {
        double totalAmount = 0;
        for (Product a : boughtProducts){
            if(a instanceof DigitalEquipment)
                totalAmount+=a.getPrice()*((DigitalEquipment) a).getDiscountPercentage()*0.01;
            else if(a instanceof Pen)
                totalAmount+=a.getPrice()*((Pen) a).getDiscountPercentage()*0.01;
            else if(a instanceof Pencil)
                totalAmount+=a.getPrice()*((Pencil) a).getDiscountPercentage()*0.01;
            else totalAmount += a.getPrice();
        }
        return totalAmount;
    }

    private double calculateTotalDiscount(){
        if(appliedDiscountCodes.size()==0) return 0;
        double totalDiscount=1;
        for(DiscountCode a: appliedDiscountCodes)
            totalDiscount*=a.getPercentage()*0.01;
        return totalDiscount;
    }

    private double calculateFinalAmount(){
        return this.totalAmount-(this.totalAmount*this.totalDiscount);
    }

    public String getID() {
        return ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public ArrayList<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public ArrayList<DiscountCode> getAppliedDiscountCodes() {
        return appliedDiscountCodes;
    }

    @Override
    public String toString() {
        StringBuilder boughtProduct = new StringBuilder();
        for (Product a : this.boughtProducts)
            boughtProduct.append("\nname: ").append(a.getName()).append("\nprice: ").append(a.getPrice());
        return "\nID: " + ID + "\ndate: " + date + "\ntotal amount: " + totalAmount + boughtProduct;
    }
}

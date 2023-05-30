package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Discountable;

public class Pen extends Stationary implements Discountable {
    private PenColor color;
    private double discountPercentage;
    //private int discountCapacity;

    public Pen(String color, String manufacturingCountry, String name, int price, int numberOfNewProduct) {
        super(manufacturingCountry, name, price, numberOfNewProduct);
        this.color = PenColor.valueOf(color.toUpperCase());
    }

    public PenColor getColor() {
        return color;
    }

    public void setColor(PenColor color) {
        this.color = color;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    /*
    public int getDiscountCapacity() {
        return discountCapacity;
    }

    public void setDiscountCapacity(int discountCapacity) {
        this.discountCapacity = discountCapacity;
    }
     */

    @Override
    public void applyDiscount(double percentage, int capacity){
        this.discountPercentage=percentage;
        this.setPrice(this.getPrice()-(this.getPrice()*this.discountPercentage*0.01));
        //this.discountCapacity=capacity;
    }

    @Override
    public void rescindDiscount(){
        this.setPrice((this.getPrice()*100)/(100-this.getDiscountPercentage()));
        this.discountPercentage=0;
        //this.discountCapacity=0;
    }


    @Override
    public String toString() {
        return "\ncolor: " + color.toString().toLowerCase() + super.toString();
    }
}

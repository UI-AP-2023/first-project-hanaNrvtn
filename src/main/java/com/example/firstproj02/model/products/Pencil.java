package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Discountable;

public class Pencil extends Stationary implements Discountable {
    private PencilType type;
    private double discountPercentage;
    //private int discountCapacity;


    public Pencil(String type, String manufacturingCountry, String name, int price, int numberOfProduct) {
        super(manufacturingCountry, name, price, numberOfProduct);
        this.type = PencilType.valueOf(type);
    }

    public PencilType getType() {
        return type;
    }

    public void setType(PencilType type) {
        this.type = type;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

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

    public String toString1() {
        return "pencil type: " + type.toString() + super.toString1();
    }
    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}

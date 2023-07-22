package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Discountable;

abstract public class DigitalEquipment extends Product implements Discountable {
    private double weight;
    private String dimension;
    private double discountPercentage;
    //private int discountCapacity;

    public DigitalEquipment(double weight, String dimension, String name, int price, int numberOfProduct) {
        super(ProductCategory.DIGITAL_EQUIPMENT, name, price, numberOfProduct);
        this.weight = weight;
        this.dimension = dimension;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
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
        return "weight: " + weight + "\nlength: " + dimension.split(":")[0] + "\nwidth: " + dimension.split(":")[1] + "\nheight: " + dimension.split(":")[2] + super.toString1();
    }
}


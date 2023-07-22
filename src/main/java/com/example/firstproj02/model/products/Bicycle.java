package com.example.firstproj02.model.products;

import com.example.firstproj02.model.processes.Comment;

public class Bicycle extends Vehicle {
    private BikeType type;

    public Bicycle(String type, String manufacturer, String name, int price, int numberOfNewProduct) {
        super(manufacturer, name, price, numberOfNewProduct);
        this.type = BikeType.valueOf(type.toUpperCase());
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    public String toString1() {
        StringBuilder comments = new StringBuilder();
        for (Comment a : getComments())
            comments.append("\n").append(a.getUser().getUserName()).append("\n").append(a.getText()).append("\n=-=-=-=-=-=-=-=-=-=-=-=");
        return super.getName() + "\ntype:  " + type.toString().toLowerCase() + "\nproduced by:  " + super.getManufacturer() + "\nprice:  " + super.getPrice() + "$\nstatus:  " + super.getAvailable() + "\nscore:  " + String.format("%.2f", super.getScore()) + "\n=-=-=-=-=-=-=-=-=-=-=-=\n" + "comments: " + comments;
    }
}

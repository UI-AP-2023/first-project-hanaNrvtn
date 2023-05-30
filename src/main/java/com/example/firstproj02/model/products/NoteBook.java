package com.example.firstproj02.model.products;

public class NoteBook extends Stationary {
    private int numberOfPages;
    private String paperType;

    public NoteBook(int numberOfPages, String paperType, String manufacturingCountry, String name, int price, int numberOfNewProduct) {
        super(manufacturingCountry, name, price, numberOfNewProduct);
        this.numberOfPages = numberOfPages;
        this.paperType = paperType;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    @Override
    public String toString() {
        return "\nnumber of pages: " + numberOfPages + "\npaper type: " + paperType + super.toString();
    }
}

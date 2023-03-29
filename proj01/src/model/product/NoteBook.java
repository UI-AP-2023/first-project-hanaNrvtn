package model.product;

public class NoteBook extends Stationary {
    private int numberOfPages;
    private String paperType;

    public NoteBook(String category, String name, int price, int numberOfSupply, String manufacturingCountry, int numberOfPages, String paperType) {
        super(category, name, price, numberOfSupply, manufacturingCountry);
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
        return super.toString() + "\nnumber of pages: " + numberOfPages + "\npaper type: " + paperType;
    }
}

package controller;

import model.product.*;
import model.user.Admin;
import model.user.CommentCheckRequest;
import model.user.Customer;
import model.user.Invoice;
import java.util.ArrayList;

public class ProductController {
    private static final ProductController productController=new ProductController();
    private final ArrayList<Product> products;

    private ProductController(){
        AdminController adminController = AdminController.getInstance();
        products= adminController.getAdmin().getProducts();
    }

    public static ProductController getInstance() {
        return productController;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product findProduct(String ID){
        for(Product a: products)
            if(a.getID().equals(ID))
                return a;
        return null;
    }

    public ArrayList<Product> divideProducts(ArrayList<Product> products, int numberInEachPage, int start){
        ArrayList<Product> productsInPage=new ArrayList<>();
        for(int i=start; i<start+numberInEachPage && i< products.size(); ++i)
            productsInPage.add(products.get(i));
        return productsInPage;
    }

    public ArrayList<Product> findMatches(String name){
        ArrayList<Product> matchedProducts=new ArrayList<>();
        for(Product a: products)
            if(a.getName().contains(name)) matchedProducts.add(a);
        return matchedProducts;
    }

    public ArrayList<Product> filterByPrice(ArrayList<Product> products, double desiredFloor, double desiredCeil){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a.getPrice()>=desiredFloor && a.getPrice()<=desiredCeil) filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterBySupplyStatus(ArrayList<Product> products, boolean desiredStatus){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a.getAvailable()==desiredStatus) filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterByGeneralCategory(ArrayList<Product> products, ProductCategory category){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products){
            if(a.getCategory().equals(category))
                filteredProducts.add(a);
        }
        return filteredProducts;
    }

    public ArrayList<Product> filterDataStorageEquipments(ArrayList<Product> products){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof DataStorageEquipment)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterFlashMemories(ArrayList<Product> products){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof FlashMemory)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterUSBVersion(ArrayList<Product> products, double USBVersion){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof FlashMemory flashMemory && flashMemory.getUSBVersion()==USBVersion)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterSSDs(ArrayList<Product> products){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof SSD)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterReadSpeed(ArrayList<Product> products, int readSpeed){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof SSD ssd && ssd.getReadSpeed()==readSpeed)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterPCs(ArrayList<Product> products){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof PC)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterRAMCapacity(ArrayList<Product> products, int RAMCapacity){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof PC pc && pc.getRAMCapacity()==RAMCapacity)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterBicycles(ArrayList<Product> products){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof Bicycle)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterBikeType(ArrayList<Product> products, BikeType bikeType){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof Bicycle bicycle && bicycle.getType().equals(bikeType))
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterCars(ArrayList<Product> products){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof Car)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterAutomatic(ArrayList<Product> products, boolean isAutomatic){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof Car car && car.getAutomatic()==isAutomatic)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterPens(ArrayList<Product> products){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof Pen)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterPenColor(ArrayList<Product> products, PenColor color){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof Pen pen && pen.getColor().equals(color))
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterPencils(ArrayList<Product> products){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof Pencil)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterPencilType(ArrayList<Product> products, PencilType pencilType){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof Pencil pencil && pencil.getType().equals(pencilType))
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterNoteBooks(ArrayList<Product> products){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof NoteBook)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public ArrayList<Product> filterNumberOfPages(ArrayList<Product> products, int numberOfPages){
        ArrayList<Product> filteredProducts=new ArrayList<>();
        for(Product a: products)
            if(a instanceof NoteBook noteBook && noteBook.getNumberOfPages()==numberOfPages)
                filteredProducts.add(a);
        return filteredProducts;
    }

    public void commentToProduct(Customer customer, Product product, String text){
        Comment newComment=new Comment(customer, product.getID(), text, checkBoughtProduct(customer, product));
        CommentCheckRequest newCommentCheckRequest=new CommentCheckRequest(newComment);
        Admin.getAdmin().getRequests().add(newCommentCheckRequest);
    }

    public boolean checkBoughtProduct(Customer customer, Product product){
        for(Invoice a: customer.getInvoices())
            if(a.getBoughtProducts().contains(product))
                return true;
        return false;
    }
}

package controller;

import model.product.*;
import model.user.*;

import java.util.ArrayList;
import java.util.Objects;

public class AdminController {
    private static final AdminController instance = new AdminController();
    private final CustomerController customerController = CustomerController.getInstance();
    private final Admin admin;

    private AdminController() {
        admin = Admin.getInstance("admin", "admin@gmail.com", "09137899023", "admin");
    }

    public static AdminController getInstance() {
        return instance;
    }

    public Admin getAdmin() {
        return admin;
    }

    public boolean login(String userName, String password) {
        return userName.equals(admin.getUserName()) && password.equals(admin.getPassword());
    }

    private Product findProduct(String ID) {
        for (Product a : admin.getProducts())
            if (a.getID().equals(ID))
                return a;
        return null;
    }

    public void addFlashMemory(double USBVersion, int capacity, double weight, String dimension, String name, int price, int numberOfNewProduct) {
        FlashMemory flashMemory = new FlashMemory(USBVersion, capacity, weight, dimension, name, price, numberOfNewProduct);
        admin.getProducts().add(flashMemory);
    }

    public void addSSD(int readSpeed, int writeSpeed, int capacity, double weight, String dimension, String name, int price, int numberOfProduct) {
        SSD SSD = new SSD(readSpeed, writeSpeed, capacity, weight, dimension, name, price, numberOfProduct);
        admin.getProducts().add(SSD);
    }

    public void addPC(String CPUModel, int RAMCapacity, double weight, String dimension, String name, int price, int numberOfProduct) {
        PC PC = new PC(CPUModel, RAMCapacity, weight, dimension, name, price, numberOfProduct);
        admin.getProducts().add(PC);
    }

    public void addPencil(String type, String manufacturingCountry, String name, int price, int numberOfProduct) {
        Pencil pencil = new Pencil(type, manufacturingCountry, name, price, numberOfProduct);
        admin.getProducts().add(pencil);
    }

    public void addPen(String color, String manufacturingCountry, String name, int price, int numberOfNewProduct) {
        Pen pen = new Pen(color, manufacturingCountry, name, price, numberOfNewProduct);
        admin.getProducts().add(pen);
    }

    public void addNoteBook(int numberOfPages, String paperType, String manufacturingCountry, String name, int price, int numberOfNewProduct) {
        NoteBook noteBook = new NoteBook(numberOfPages, paperType, manufacturingCountry, name, price, numberOfNewProduct);
        admin.getProducts().add(noteBook);
    }

    public void addBicycle(String type, String manufacturer, String name, int price, int numberOfNewProduct) {
        Bicycle bicycle = new Bicycle(type, manufacturer, name, price, numberOfNewProduct);
        admin.getProducts().add(bicycle);
    }

    public void addCar(int motorCapacity, boolean isAutomatic, String manufacturer, String name, int price, int numberOfNewProduct) {
        Car car = new Car(motorCapacity, isAutomatic, manufacturer, name, price, numberOfNewProduct);
        admin.getProducts().add(car);
    }

    public void addEdibleProduct(String productionDate, String expirationDate, String name, int price, int numberOfNewProduct) {
        EdibleProduct edibleProduct = new EdibleProduct(productionDate, expirationDate, name, price, numberOfNewProduct);
        admin.getProducts().add(edibleProduct);
    }

    public boolean removeProduct(String ID) {
        return admin.getProducts().removeIf(n -> n.getID().equals(ID));
    }

    public boolean editProductName(String ID, String name) {
        if (findProduct(ID) == null) return false;
        Objects.requireNonNull(findProduct(ID)).setName(name);
        return true;
    }

    public boolean editProductPrice(String ID, int price) {
        if (findProduct(ID) == null) return false;
        Objects.requireNonNull(findProduct(ID)).setPrice(price);
        return true;
    }

    public boolean editNumberOfProduct(String ID, int numberOfNewProduct) {
        if (findProduct(ID) == null) return false;
        int currentNumber = Objects.requireNonNull(findProduct(ID)).getNumberOfProduct();
        Objects.requireNonNull(findProduct(ID)).setNumberOfProduct(currentNumber + numberOfNewProduct);
        return true;
    }

    public ArrayList<User> showAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(admin);
        users.addAll(customerController.getCustomers());
        return users;
    }

    public ArrayList<Product> showAllProducts() {
        return admin.getProducts();
    }

    public ArrayList<RegistrationRequest> showAllRegistrationRequests() {
        ArrayList<RegistrationRequest> registrationRequests = new ArrayList<>();
        for (Request a : admin.getRequests())
            if (a instanceof RegistrationRequest registrationRequest)
                registrationRequests.add(registrationRequest);
        return registrationRequests;
    }

    public ArrayList<CommentCheckRequest> showAllCommentCheckRequests() {
        ArrayList<CommentCheckRequest> commentCheckRequests = new ArrayList<>();
        for (Request a : admin.getRequests())
            if (a instanceof CommentCheckRequest commentCheckRequest)
                commentCheckRequests.add(commentCheckRequest);
        return commentCheckRequests;
    }

    public ArrayList<IncreaseCreditRequest> showAllIncreaseCreditRequests() {
        ArrayList<IncreaseCreditRequest> increaseCreditRequests = new ArrayList<>();
        for (Request a : admin.getRequests())
            if (a instanceof IncreaseCreditRequest increaseCreditRequest)
                increaseCreditRequests.add(increaseCreditRequest);
        return increaseCreditRequests;
    }

    public Request findRequest(RequestType requestType, String userName) {
        for (Request a : admin.getRequests()) {
            if (a instanceof RegistrationRequest registrationRequest) {
                if (registrationRequest.getCustomer().getUserName().equals(userName) && registrationRequest.getRequestType().equals(requestType))
                    return registrationRequest;
            } else if (a instanceof CommentCheckRequest commentCheckRequest) {
                if (commentCheckRequest.getComment().getUser().getUserName().equals(userName) && commentCheckRequest.getRequestType().equals(requestType))
                    return commentCheckRequest;
            } else if (a instanceof IncreaseCreditRequest increaseCreditRequest) {
                if (increaseCreditRequest.getCustomer().getUserName().equals(userName) && increaseCreditRequest.getRequestType().equals(requestType))
                    return increaseCreditRequest;
            }
        }
        return null;
    }

    public boolean acceptRegistrationRequest(Request request) {  // SHOW REQUEST BY INDEX
        if (request instanceof RegistrationRequest registrationRequest) {
            customerController.getCustomers().add(registrationRequest.getCustomer());
            admin.getRequests().remove(request);
            return true; // accepted successfully
        }
        return false;  // request not found
    }

    public boolean rejectRegistrationRequest(Request request) {
        return admin.getRequests().remove(request); //request not found or rejected successfully
    }

    public boolean acceptCommentCheckRequest(Request request) {
        if (request instanceof CommentCheckRequest commentCheckRequest) {
            ProductController productController = ProductController.getInstance();
            productController.findProduct(commentCheckRequest.getComment().getID()).getComments().add(commentCheckRequest.getComment());
            ((CommentCheckRequest) request).getComment().setStatus(CommentStatus.VERIFIED);
            admin.getRequests().remove(request);
            return true; // accepted successfully
        }
        return false;  // request not found
    }

    public boolean rejectCommentCheckRequest(Request request) {
        return admin.getRequests().remove(request); //request not found or rejected successfully
    }

    public boolean acceptIncreaseCreditRequest(Request request) {
        if (request instanceof IncreaseCreditRequest increaseCreditRequest) {
            increaseCreditRequest.getCustomer().setCredit(increaseCreditRequest.getCustomer().getCredit() + increaseCreditRequest.getAdditionalCredit());
            admin.getRequests().remove(request);
            return true; // accepted successfully
        }
        return false;  // request not found
    }

    public boolean rejectIncreaseCreditRequest(Request request) {
        return admin.getRequests().remove(request); //request not found or rejected successfully
    }
}

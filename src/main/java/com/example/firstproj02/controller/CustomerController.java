package com.example.firstproj02.controller;

import com.example.firstproj02.model.accounts.Admin;
import com.example.firstproj02.model.accounts.Customer;
import com.example.firstproj02.model.exceptions.*;
import com.example.firstproj02.model.processes.*;
import com.example.firstproj02.model.products.FlashMemory;
import com.example.firstproj02.model.products.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerController {
    private static final CustomerController instance = new CustomerController();
    private final ArrayList<Customer> customers;

    public CustomerController() {
        customers = new ArrayList<>();
        Customer customer = new Customer("ali", "ali@gmail.com", "09131109898", "123");  //
        customers.add(customer);
        ArrayList<Product> products=new ArrayList<>();
        FlashMemory flashMemory=new FlashMemory(2, 90, 90, "12:12:12", "jsd", 90, 90);
        products.add(flashMemory);
        Invoice invoice1=new Invoice(LocalDate.now(), products);
        Invoice invoice2=new Invoice(LocalDate.now(), products);
        Invoice invoice3=new Invoice(LocalDate.now(), products);
        Invoice invoice4=new Invoice(LocalDate.now(), products);
        ArrayList<Invoice> invoices=new ArrayList<>();
        DiscountCode discountCode1=new DiscountCode(90, LocalDate.now(), 90, DiscountType.ENCOURAGING);
        DiscountCode discountCode2=new DiscountCode(90, LocalDate.now(), 90, DiscountType.ENCOURAGING);
        DiscountCode discountCode3=new DiscountCode(90, LocalDate.now(), 90, DiscountType.ENCOURAGING);
        customer.getDiscountCodes().add(discountCode1);
        customer.getDiscountCodes().add(discountCode2);
        customer.getDiscountCodes().add(discountCode3);
        customer.getInvoices().add(invoice1);
        customer.getInvoices().add(invoice2);
        customer.getInvoices().add(invoice3);
        customer.getInvoices().add(invoice4);
    }

    public static CustomerController getInstance() {
        return instance;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void checkEmailRegex(String email) throws InvalidEmailException {
        Pattern pattern = Pattern.compile("^\\w+@(gmail|yahoo)\\.com$");
        Matcher matcher = pattern.matcher(email);
        if(!matcher.find()) throw new InvalidEmailException();
    }

    public void checkPhoneNumberRegex(String phoneNumber) throws InvalidPhoneNumberException {
        Pattern pattern = Pattern.compile("^09\\d{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if(!matcher.find()) throw new InvalidPhoneNumberException();
    }

    public void checkPasswordRegex(String password) throws InvalidPasswordException {
        Pattern pattern1 = Pattern.compile("^\\S{8,12}$");
        Matcher matcher1 = pattern1.matcher(password);

        Pattern pattern2 = Pattern.compile("[A-Z]+");
        Matcher matcher2 = pattern2.matcher(password);

        Pattern pattern3 = Pattern.compile("[a-z]+");
        Matcher matcher3 = pattern3.matcher(password);

        Pattern pattern4 = Pattern.compile("\\d+");
        Matcher matcher4 = pattern4.matcher(password);

        Pattern pattern5 = Pattern.compile("([@#$%&*!])+");
        Matcher matcher5 = pattern5.matcher(password);

        if(!matcher1.find() || !matcher2.find() || !matcher3.find() || !matcher4.find() || !matcher5.find())
            throw new InvalidPasswordException();
    }

    public void checkUserNameAvailability(String userName) throws UnavailableUserNameException {
        boolean isFound=false;
        for (Customer a : customers)
            if (a.getUserName().equals(userName)) {
                isFound = true;
                break;
            }
        if(isFound) throw new UnavailableUserNameException();
    }

    public void checkEmailAvailability(String email) throws UnavailableEmailException {
        boolean isFound=false;
        for (Customer a : customers)
            if (a.getEmail().equals(email)){
                isFound=true;
                break;
            }
        if(isFound) throw new UnavailableEmailException();
    }

    public void checkPhoneNumberAvailability(String phoneNumber) throws UnavailablePhoneNumberException {
        boolean isFound=false;
        for (Customer a : customers)
            if (a.getPhoneNumber().equals(phoneNumber)){
                isFound=true;
                break;
            }
        if(isFound) throw new UnavailablePhoneNumberException();
    }

    public Customer login(String userName, String password) {
        for (Customer a : customers)
            if (a.getUserName().equals(userName) && a.getPassword().equals(password))
                return a;
        return null;
    }

    public void signup(String email, String phoneNumber, String userName, String password) {
        Customer newCustomer = new Customer(userName, email, phoneNumber, password);
        RegistrationRequest newRegistrationRequest = new RegistrationRequest(newCustomer);
        AdminController.getInstance().getAdmin().getRequests().add(newRegistrationRequest);
    }

    public void editEmail(Customer customer, String newEmail) {
        customer.setEmail(newEmail);
    }

    public void editPhoneNumber(Customer customer, String newPhoneNumber) {
        customer.setPhoneNumber(newPhoneNumber);
    }

    public void editPassword(Customer customer, String newPassword) {
        customer.setPassword(newPassword);
    }

    public void editFirstName(Customer customer, String newFirstName){
        customer.setFirstName(newFirstName);
    }

    public void editLastName(Customer customer, String newLastName){
        customer.setLastName(newLastName);
    }

    public int productCounter(ArrayList<Product> products, Product product) {
        int counter = 0;
        for (Product a : products) if (a.equals(product)) ++counter;
        return counter;
    }

    public ArrayList<Product> uniqueProducts(ArrayList<Product> products) {
        ArrayList<Product> uniqueProducts = new ArrayList<>();
        for (Product a : products) if (!uniqueProducts.contains(a)) uniqueProducts.add(a);
        return uniqueProducts;
    }

    public boolean editNumberOfProductInShoppingCart(ArrayList<Product> shoppingCart, Product product, int newNumber) {
        if (product.getNumberOfProduct() < newNumber || !removeProductFromShoppingCart(shoppingCart, product))
            return false;
        for (int i = 0; i < newNumber; ++i)
            shoppingCart.add(product);
        return true;
    }

    public boolean removeProductFromShoppingCart(ArrayList<Product> shoppingCart, Product product) {  //
        return shoppingCart.removeIf(n -> n.equals(product));
    }

    public Product findProduct(ArrayList<Product> products, String ID) {
        for (Product a : products)
            if (a.getID().equals(ID))
                return a;
        return null;
    }

    public Invoice invoiceShoppingCart(Customer customer) {  //
        ArrayList<Product> availableProducts = new ArrayList<>();
        for (Product a : customer.getCart())
            if (a.getAvailable())
                availableProducts.add(a);
        Invoice newInvoice = new Invoice(LocalDate.now(), availableProducts);
        if (newInvoice.getTotalAmount() <= customer.getCredit()) {
            customer.getCart().clear();
            customer.setCredit(customer.getCredit() - newInvoice.getFinalAmount());
            customer.getInvoices().add(newInvoice);
            newInvoice.getAppliedDiscountCodes().forEach(n -> n.setCapacity(n.getCapacity() - 1));
            return newInvoice;
        }
        return null;
    }

    private ArrayList<Product> getAvailableProducts(ArrayList<Product> shoppingCart) {
        ArrayList<Product> availableProducts = new ArrayList<>();
        for (Product a : shoppingCart)
            if (a.getAvailable())
                availableProducts.add(a);
        return availableProducts;
    }

    private String creatMessage(ArrayList<Product> unavailableProducts) {
        StringBuilder message = new StringBuilder();
        for (Product a : unavailableProducts)
            message.append(a.getName()).append(" & ");
        return message.toString();
    }

    private void checkProductSupply(ArrayList<Product> shoppingCart) throws NoEnoughSupplyException {
        ArrayList<Product> unAvailableProducts = new ArrayList<>();
        for (Product a : shoppingCart)
            if (!a.getAvailable())
                unAvailableProducts.add(a);
        if (unAvailableProducts.size() > 0)
            throw new NoEnoughSupplyException("unavailable products: " + creatMessage(unAvailableProducts));
    }

    public Invoice invoiceShoppingCart0(Customer customer) throws NoEnoughSupplyException {  // called in initialize of finalize-page-controller
        checkProductSupply(customer.getCart());
        return new Invoice(LocalDate.now(), getAvailableProducts(customer.getCart()));
    }

    private void checkCustomerCredit(Customer customer, Invoice invoice) throws NoEnoughCreditException {
        if (invoice.getFinalAmount() > customer.getCredit()) throw new NoEnoughCreditException();
    }

    public void updateSupplyOfInvoicedProducts(Invoice invoice) {
        for (Product a : invoice.getBoughtProducts())
            a.setNumberOfProduct(a.getNumberOfProduct() - 1);
    }

    public void verifyShopping(Customer customer, Invoice invoice) throws NoEnoughCreditException {
        checkCustomerCredit(customer, invoice);
        updateSupplyOfInvoicedProducts(invoice);
        customer.getCart().clear();
        customer.setCredit(customer.getCredit() - invoice.getFinalAmount());
        invoice.getAppliedDiscountCodes().forEach(n -> n.setCapacity(n.getCapacity() - 1));
        customer.getInvoices().add(invoice);
    }

    private void checkDiscountCodeExpiration(DiscountCode discountCode) throws ExpiredDiscountCodeException {
        if(discountCode.getExpiration().isBefore(LocalDate.now())) throw new ExpiredDiscountCodeException();
    }

    private void checkDiscountCodeAvailability(DiscountCode discountCode) throws UnavailableDiscountCodeException {
        if(discountCode.getCapacity()==0) throw new UnavailableDiscountCodeException();
    }

    private void checkDiscountCodeExistence(Customer customer, DiscountCode discountCode) throws NotFoundDiscountCodeException {
        boolean isFound=false;
        for(DiscountCode a: customer.getDiscountCodes())
            if (a.getCode().equals(discountCode.getCode())) {
                isFound = true;
                break;
            }
        if(!isFound) throw new NotFoundDiscountCodeException();
    }

    public void applyDiscountCode(Customer customer, Invoice invoice, DiscountCode discountCode) throws NotFoundDiscountCodeException, ExpiredDiscountCodeException, UnavailableDiscountCodeException {
        checkDiscountCodeExistence(customer, discountCode);
        checkDiscountCodeExpiration(discountCode);
        checkDiscountCodeAvailability(discountCode);
        invoice.getAppliedDiscountCodes().add(discountCode);
        invoice.updateFinalAmount();
    }

    public void checkCreditCardRegex(String creditCardNumber) throws InvalidCreditCardNumberException {
        Pattern pattern = Pattern.compile("^\\d{16}$");
        Matcher matcher = pattern.matcher(creditCardNumber);
        if(!matcher.find()) throw new InvalidCreditCardNumberException();
    }

    public void checkCVV2Regex(String CVV2) throws InvalidCVV2Exception {
        Pattern pattern = Pattern.compile("^\\d{3,4}$");
        Matcher matcher = pattern.matcher(CVV2);
        if(!matcher.find()) throw new InvalidCVV2Exception();
    }

    public void checkCardPasswordRegex(String password) throws InvalidCardPasswordException {
        Pattern pattern = Pattern.compile("^\\d{8}$");
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find()) throw new InvalidCardPasswordException();
    }

    public void creatIncreaseCreditRequest(Customer customer, double additionalCredit, String creditCardNumber, String CVV2, String password) {
        IncreaseCreditRequest newIncreaseCreditRequest = new IncreaseCreditRequest(customer, additionalCredit, creditCardNumber, CVV2, password);
        Admin.getAdmin().getRequests().add(newIncreaseCreditRequest);
    }

    public Product findProductInCustomerInvoices(Customer customer, String ID){
        for(Invoice a: customer.getInvoices())
            for(Product b: a.getBoughtProducts())
                if(b.getID().equals(ID))
                    return b;
        return null;
    }

    public void rateProduct(Customer customer, Product product, double score) {
        Rate newRate = new Rate(customer, product, score);
        product.getRates().add(newRate);
        updateAverageScore(product);
    }

    private void updateAverageScore(Product product) {
        double totalScore = 0;
        for (Rate a : product.getRates())
            totalScore += a.getScore();
        product.setScore(totalScore / product.getRates().size());
    }

    public ArrayList<DiscountCode> showAllDiscountCodes(Customer customer) throws NullPointerException {  //
        return customer.getDiscountCodes();
    }

    //public void checkg

}

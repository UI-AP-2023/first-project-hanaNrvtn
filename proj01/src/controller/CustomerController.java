package controller;

import model.product.Product;
import model.product.Rate;
import model.user.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerController {
    private static final CustomerController instance=new CustomerController();
    private final ArrayList<Customer> customers;

    private CustomerController(){
        customers=new ArrayList<>();
        Customer customer=new Customer("ali", "ali@gmail.com", "09131109898", "123");  //
        customers.add(customer);
    }

    public static CustomerController getInstance() {
        return instance;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean checkEmailRegex(String email){
        Pattern pattern=Pattern.compile("^\\w+@(gmail|yahoo)\\.com$");
        Matcher matcher=pattern.matcher(email);
        return !matcher.find();
    }

    public boolean checkPhoneNumberRegex(String phoneNumber){
        Pattern pattern=Pattern.compile("^09\\d{9}$");
        Matcher matcher=pattern.matcher(phoneNumber);
        return !matcher.find();
    }

    public boolean checkPasswordRegex(String password){
        Pattern pattern1=Pattern.compile("^\\S{8,12}$");
        Matcher matcher1=pattern1.matcher(password);

        Pattern pattern2=Pattern.compile("[A-Z]+");
        Matcher matcher2=pattern2.matcher(password);

        Pattern pattern3=Pattern.compile("[a-z]+");
        Matcher matcher3=pattern3.matcher(password);

        Pattern pattern4=Pattern.compile("\\d+");
        Matcher matcher4=pattern4.matcher(password);

        Pattern pattern5=Pattern.compile("([@#$%&*!])+");
        Matcher matcher5=pattern5.matcher(password);

        return !matcher1.find() || !matcher2.find() || !matcher3.find() || !matcher4.find() || !matcher5.find();
    }

    public boolean checkUserNameAvailability(String userName){
        for(Customer a: customers)
            if(a.getUserName().equals(userName))
                return true;
        return false;
    }

    public boolean checkEmailAvailability(String email){
        for(Customer a: customers)
            if(a.getEmail().equals(email))
                return true;
        return false;
    }

    public boolean checkPhoneNumberAvailability(String phoneNumber){
        for(Customer a: customers)
            if(a.getPhoneNumber().equals(phoneNumber))
                return true;
        return false;
    }

    public Customer login(String userName, String password) {
        for (Customer a : customers)
            if (a.getUserName().equals(userName) && a.getPassword().equals(password))
                return a;
        return null;
    }

    public void signup(String userName, String email, String phoneNumber, String password){
        Customer newCustomer=new Customer(userName, email, phoneNumber, password);
        RegistrationRequest newRegistrationRequest=new RegistrationRequest(newCustomer);
        Admin.getAdmin().getRequests().add(newRegistrationRequest);
    }

    public void editEmail(Customer customer, String newEmail){
        customer.setEmail(newEmail);
    }

    public void editPhoneNumber(Customer customer, String newPhoneNumber){
        customer.setPhoneNumber(newPhoneNumber);
    }

    public void editPassword(Customer customer, String newPassword){
        customer.setPassword(newPassword);
    }

    public boolean addToShoppingCart(ArrayList<Product> shoppingCart, Product product, int numberOfProduct){
        if(numberOfProduct<=product.getNumberOfProduct()){
            for(int i=0; i<numberOfProduct; ++i)
                shoppingCart.add(product);
            return true;
        }
        return false;
    }

    public int productCounter(ArrayList<Product> products, Product product){
        int counter=0;
        for(Product a: products) if(a.equals(product)) ++counter;
        return counter;
    }

    public ArrayList<Product> uniqueProducts(ArrayList<Product> products){
        ArrayList<Product> uniqueProducts=new ArrayList<>();
        for(Product a: products) if(!uniqueProducts.contains(a)) uniqueProducts.add(a);
        return uniqueProducts;
    }

    public boolean editNumberOfProductInShoppingCart(ArrayList<Product> shoppingCart, Product product, int newNumber){
        if(product.getNumberOfProduct()<newNumber || !removeProductFromShoppingCart(shoppingCart, product)) return false;
        for(int i=0; i<newNumber; ++i)
            shoppingCart.add(product);
        return true;
    }

    public boolean removeProductFromShoppingCart(ArrayList<Product> shoppingCart, Product product){  //
        return shoppingCart.removeIf(n->n.equals(product));
    }

    public Product findProduct(ArrayList<Product> products, String ID){
        for(Product a: products)
            if(a.getID().equals(ID))
                return a;
        return null;
    }

    public Invoice invoiceShoppingCart(Customer customer){  //
        ArrayList<Product> availableProducts=new ArrayList<>();
        for(Product a: customer.getCart())
            if(a.getAvailable())
                availableProducts.add(a);
        Invoice newInvoice=new Invoice(LocalDate.now().toString(), availableProducts);
        if(newInvoice.getTotalAmount()<=customer.getCredit()){
            customer.getCart().clear();
            customer.setCredit(customer.getCredit()-newInvoice.getTotalAmount());
            customer.getInvoices().add(newInvoice);
            return newInvoice;
        }
        return null;
    }

    public void updateSupplyOfInvoicedProducts(Invoice invoice){
        for(Product a: invoice.getBoughtProducts())
            a.setNumberOfProduct(a.getNumberOfProduct()-1);
    }

    public boolean checkCreditCardRegex(String creditCardNumber){
        Pattern pattern=Pattern.compile("^\\d{16}$");
        Matcher matcher=pattern.matcher(creditCardNumber);
        return matcher.find();
    }

    public boolean checkCVV2Regex(String CVV2){
        Pattern pattern=Pattern.compile("^\\d{3,4}$");
        Matcher matcher=pattern.matcher(CVV2);
        return matcher.find();
    }

    public boolean checkCardPasswordRegex(String password){
        Pattern pattern=Pattern.compile("^\\d{8}$");
        Matcher matcher=pattern.matcher(password);
        return matcher.find();
    }

    public void creatIncreaseCreditRequest(Customer customer, double additionalCredit){
        IncreaseCreditRequest newIncreaseCreditRequest=new IncreaseCreditRequest(customer, additionalCredit);
        Admin.getAdmin().getRequests().add(newIncreaseCreditRequest);
    }

    public void rateProduct(Customer customer, Product product, int score){
        Rate newRate=new Rate(customer, product, score);
        product.getRates().add(newRate);
        updateAverageScore(product);
    }

    private void updateAverageScore(Product product){
        double totalScore=0;
        for(Rate a: product.getRates())
            totalScore+=a.getScore();
         product.setScore(totalScore/product.getRates().size());
    }
}

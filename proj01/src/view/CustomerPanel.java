package view;

import controller.CustomerController;
import model.product.Product;
import model.user.Customer;
import model.user.Invoice;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerPanel {
    private final Customer customer;
    private final CustomerController customerController;
    private final Scanner scanner;

    public CustomerPanel(Customer customer, ArrayList<Product> tempShoppingCart){
        customerController=CustomerController.getInstance();
        scanner=new Scanner(System.in);
        this.customer=customer;
        if(customer!=null && tempShoppingCart.size()!=0)
            customer.getCart().addAll(tempShoppingCart);
    }

    public void showMenu(){
        while (true){
            System.out.println("1. edit profile \n2. go to product page \n3. go to shopping cart \n4. go to shopping history \n5. charge credit \n6. back to previous \n7. exit");
            switch (scanner.nextInt()){
                case 1:
                    editProfile();
                    continue;
                case 2:
                    ProductPanel productPanel=new ProductPanel(customer);
                    productPanel.showMenu();
                    continue;
                case 3:
                    shoppingCartPage(customer.getCart());
                    continue;
                case 4:
                    shoppingHistoryPage();
                    continue;
                case 5:
                    paymentPage();
                    continue;
                case 6:
                    return;
                case 7:
                    System.exit(0);
            }
        }
    }

    private void editProfile(){
        System.out.println("1. email \n2. phone number \n3. password \n4. back to previous \n5. exit");
        switch (scanner.nextInt()){
            case 1:
                editEmail(); break;
            case 2:
                editPhoneNumber(); break;
            case 3:
                editPassword(); break;
            case 4:
                return;
            case 5:
                System.exit(0);
        }
    }

    private void editEmail(){
        System.out.println("new email: ");
        String newEmail;
        while (true){
            newEmail=scanner.next();
            if(!customerController.checkEmailRegex(newEmail)){
                System.out.println("invalid email, try again");
            }else if(customerController.checkEmail(newEmail)){
                System.out.println("unavailable email, try again");
            }else{
                customerController.editEmail(customer, newEmail);
                System.out.println("edited successfully");
                break;
            }
        }
    }

    private void editPhoneNumber(){
        System.out.println("new phone number: ");
        String newPhoneNumber;
        while (true){
            newPhoneNumber=scanner.next();
            if(!customerController.checkEmailRegex(newPhoneNumber)){
                System.out.println("invalid phone number, try again");
            }else if(customerController.checkEmail(newPhoneNumber)){
                System.out.println("unavailable phone number, try again");
            }else{
                customerController.editPhoneNumber(customer, newPhoneNumber);
                System.out.println("edited successfully");
                break;
            }
        }
    }

    private void editPassword(){
        System.out.println("new password: ");
        String newPassword;
        while (true){
            newPassword=scanner.next();
            if(!customerController.checkEmailRegex(newPassword)){
                System.out.println("invalid password, try again");
            }else if(customerController.checkEmail(newPassword)){
                System.out.println("unavailable password, try again");
            }else{
                customerController.editPassword(customer, newPassword);
                System.out.println("edited successfully");
                break;
            }
        }
    }

    public void shoppingCartPage(ArrayList<Product> shoppingCart){
        while (true){
            for(Product a: customerController.uniqueProducts(shoppingCart))
                System.out.println("name: " + a.getName() + "\nID: " + a.getID() + "\nnumber: " + customerController.productCounter(shoppingCart, a) + "\n=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("1. edit number of product \n2. remove product \n3. finalize shopping cart \n4. back to previous \n5. exit");
            switch (scanner.nextInt()){
                case 1:
                    editNumberOfProducts(shoppingCart);
                    continue;
                case 2:
                    removeProductFromShoppingCart(shoppingCart);
                    continue;
                case 3:
                    finalizeShoppingCart(shoppingCart);
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }

    public void addToShoppingCart(ArrayList<Product> shoppingCart, Product product){
        System.out.println("number of product: ");
        if(customerController.addToShoppingCart(shoppingCart, product, scanner.nextInt())) System.out.println("added successfully");
        else System.out.println("no enough supply");
    }

    private void editNumberOfProducts(ArrayList<Product> shoppingCart){
        scanner.nextLine();
        System.out.println("product ID: ");
        Product product= customerController.findProduct(shoppingCart, scanner.nextLine());
        if(product==null) System.out.println("product not found");
        else{
            System.out.println("new number: ");
            if(customerController.editNumberOfProductInShoppingCart(shoppingCart, product, scanner.nextInt()))
                System.out.println("edited successfully");
        }
    }

    private void removeProductFromShoppingCart(ArrayList<Product> shoppingCart){
        scanner.nextLine();
        System.out.println("product ID: ");
        Product product=customerController.findProduct(shoppingCart, scanner.nextLine());
        if(product==null) System.out.println("product not found");
        else {
            customerController.removeProductFromShoppingCart(shoppingCart, product);
            System.out.println("removed successfully");
        }
    }

    public void finalizeShoppingCart(ArrayList<Product> shoppingCart){
        if(customer==null){
            System.out.println("need to be logged in \n1. log in \n2. back to previous \n3. exit");
            switch (scanner.nextInt()){
                case 1:
                    MainPanel mainPanel=new MainPanel();
                    mainPanel.loginPage(shoppingCart);
                    return;
                case 2:
                    return;
                case 3:
                    System.exit(0);
            }
        }
        else{
            System.out.println("1. verify \n2. back to previous \n3. exit");
            switch (scanner.nextInt()){
                case 1:
                    finalizeShoppingCart();
                case 2:
                    return;
                case 3:
                    System.exit(0);
            }
        }
    }

    private void finalizeShoppingCart(){
        Invoice invoice=customerController.invoiceShoppingCart(customer);
        customerController.updateSupplyOfInvoicedProducts(invoice);
        System.out.println("finalized successfully \nremain credit: " + customer.getCredit());
    }

    private void paymentPage(){
            System.out.println("adding credit: ");
            int addingCredit=scanner.nextInt();
            System.out.println("credit card number: ");
            while (true){
                if(!customerController.checkCreditCardRegex(scanner.next())){
                    System.out.println("invalid credit card number, try again");
                    continue;
                }
                System.out.println("CVV2: "); break;
            }
            while (true){
                if(!customerController.checkCVV2Regex(scanner.next())){
                    System.out.println("invalid CVV2, try again");
                    continue;
                }
                System.out.println("password: "); break;
            }
            while (true){
                if(!customerController.checkCardPasswordRegex(scanner.next())){
                    System.out.println("invalid credit card number, try again");
                    continue;
                }
                System.out.println("CVV2: "); break;
            }
            customerController.creatIncreaseCreditRequest(customer, addingCredit);
            System.out.println("credit increase request sent successfully ");
    }

    private void shoppingHistoryPage(){
        for(Invoice a: customer.getInvoices())
            System.out.println(a);
        while (true){
            System.out.println("1. rate product \n2. back to previous \n3. exit");
            switch (scanner.nextInt()){
                case 1:
                    rateProduct();
                    continue;
                case 2:
                    return;
                case 3:
                    System.exit(0);
            }
        }
    }

    private void rateProduct(){
        System.out.println("product ID: ");
        System.out.println("rate: ");
    }
}

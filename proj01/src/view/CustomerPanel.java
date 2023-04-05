package view;

import controller.AdminController;
import controller.CustomerController;
import model.product.Product;
import model.user.Admin;
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
            System.out.println("1. view profile \n2. edit profile \n3. go to product panel \n4. go to shopping cart \n5. go to shopping history \n6. charge credit \n7. back to previous \n8. exit");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println(customer);
                    continue;
                case 2:
                    editProfile();
                    continue;
                case 3:
                    ProductPanel productPanel=new ProductPanel(customer);
                    productPanel.showMenu();
                    continue;
                case 4:
                    shoppingCartPage(customer.getCart());
                    continue;
                case 5:
                    shoppingHistoryPage();
                    continue;
                case 6:
                    paymentPage();
                    continue;
                case 7:
                    return;
                case 8:
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
            if(customerController.checkEmailRegex(newEmail)){
                System.out.println("invalid email, try again");
            }else if(customerController.checkEmailAvailability(newEmail)){
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
            if(customerController.checkPhoneNumberRegex(newPhoneNumber)){
                System.out.println("invalid phone number, try again");
            }else if(customerController.checkPhoneNumberAvailability(newPhoneNumber)){
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
            if(customerController.checkPasswordRegex(newPassword)){
                System.out.println("invalid password, try again");
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
        System.out.println("product ID: ");
        Product product= customerController.findProduct(shoppingCart, scanner.next());
        if(product==null) System.out.println("product not found");
        else{
            System.out.println("new number: ");
            System.out.println(customerController.editNumberOfProductInShoppingCart(shoppingCart, product, scanner.nextInt())?"edited successfully":"no enough supplly");
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

    public void finalizeShoppingCart(ArrayList<Product> shoppingCart){  //
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
                    invoiceShoppingCart();  //
                case 2:
                    return;
                case 3:
                    System.exit(0);
            }
        }
    }

    private void invoiceShoppingCart(){
        Invoice invoice=customerController.invoiceShoppingCart(customer);
        if(invoice==null) {
            System.out.println("no enough credit");
            return;
        }
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
        for(Invoice a: customer.getInvoices()){
            System.out.println("ID: " + a.getID() + "\ndate: " + a.getDate() + "\ntotal amount: " + a.getTotalAmount());
            for(int i=0; i<customerController.uniqueProducts(a.getBoughtProducts()).size(); ++i){
                System.out.println(i +  "." + "\nname: " + customerController.uniqueProducts(a.getBoughtProducts()).get(i).getName() + "\nprice: " + customerController.uniqueProducts(a.getBoughtProducts()).get(i).getPrice() +  "\nID: " + customerController.uniqueProducts(a.getBoughtProducts()).get(i).getID() + "number: " + customerController.productCounter(a.getBoughtProducts(), customerController.uniqueProducts(a.getBoughtProducts()).get(i)) +"\n=-=-=-=-=-=-=-=-=-=-=");
            }
        }
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
        String ID=scanner.nextLine();
        System.out.println("rate(0-5): ");
        customerController.rateProduct(customer, customerController.findProduct(Admin.getAdmin().getProducts(), ID), scanner.nextInt());
    }
}

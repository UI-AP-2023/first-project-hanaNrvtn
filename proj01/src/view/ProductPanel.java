package view;

import controller.ProductController;

import model.product.Product;
import model.user.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductPanel {
    private final Customer customer;
    private final ArrayList<Product> tempCart;
    private  final ProductController productController;
    private final CustomerPanel customerPanel;
    private final Scanner scanner;

    public ProductPanel(Customer customer){
        this.customer=customer;
        productController=ProductController.getInstance();
        scanner=new Scanner(System.in);
        tempCart=new ArrayList<>();
        customerPanel=new CustomerPanel(customer, tempCart);
    }

    public void showMenu(){
        while(true){
            System.out.println("1. product page \n2. search product \n3. filter product \n4. back to previous \n5. exit");
            int command=scanner.nextInt();
            switch (command){
                case 1:
                    switchBetweenPages(productController.getProducts());
                    continue;
                case 2:
                    searchInProducts();
                    continue;
                case 3:

                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void switchBetweenPages(ArrayList<Product> products){
        System.out.println("number of product in each page: ");
        int numberInEachPage=scanner.nextInt(), i=0;

        while (i<products.size()){  //
            printEachPage(productController.divideProducts(products, numberInEachPage, i));

            if(numberInEachPage>=products.size()){
                System.out.println("1. select \n2. back to previous \n3. exit");
                switch (scanner.nextInt()){
                    case 1:
                        printProductSpecialPage();
                        continue;
                    case 2:
                        return;
                    case 3:
                        System.exit(0);
                }
            }

            else if(i==0){
                System.out.println("1. next \n2. select \n3. back to previous \n4. exit");
                switch (scanner.nextInt()){
                    case 1:
                        i+=numberInEachPage;
                        continue;
                    case 2:
                        printProductSpecialPage();
                        continue;
                    case 3:
                        return;
                    case 4:
                        System.exit(0);
                }
            }
            else if(i<products.size()-numberInEachPage){
                System.out.println("1. next \n2. previous \n3. select \n4. back to previous \n5. exit");
                switch (scanner.nextInt()){
                    case 1:
                        i+=numberInEachPage;
                        continue;
                    case 2:
                        i-=numberInEachPage;
                        continue;
                    case 3:
                        printProductSpecialPage();
                        continue;
                    case 4:
                        return;
                    case 5:
                        System.exit(0);
                }
            }
            else{
                System.out.println("1. previous \n2. select \n3. back to previous \n4. exit");
                switch (scanner.nextInt()){
                    case 1:
                        i-=numberInEachPage;
                        continue;
                    case 2:
                        printProductSpecialPage();
                        continue;
                    case 3:
                        return;
                    case 4:
                        System.exit(0);
                }
            }
        }
    }

    private void printEachPage(ArrayList<Product> productsInPage){
        for(Product a: productsInPage)
            System.out.println("name: " + a.getName() + "\nprice: " + a.getPrice() + "\nID: " + a.getID() + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    private void printProductSpecialPage(){  //
        scanner.nextLine();
        System.out.println("ID: ");
        String ID=scanner.nextLine();
        while(true){
            System.out.println(productController.findProduct(ID));
            if(customer==null){
                if(tempCart.contains(productController.findProduct(ID))){
                    System.out.println("1. go to shopping cart \n2. back to previous \n3. exit");
                    switch (scanner.nextInt()){
                        case 1:
                            customerPanel.shoppingCartPage(tempCart);
                            continue;
                        case 2:
                            return;
                        case 3:
                            System.exit(0);
                    }
                }
                else {
                    System.out.println("1. add to shopping cart \n2. go to shopping cart \n3. back to previous \n4. exit");
                    switch (scanner.nextInt()){
                        case 1:
                            customerPanel.addToShoppingCart(tempCart, productController.findProduct(ID));
                            continue;
                        case 2:
                            customerPanel.shoppingCartPage(tempCart);
                            continue;
                        case 3:
                            return;
                        case 4:
                            System.exit(0);
                    }
                }
            }
            else{
                if(customer.getCart().contains(productController.findProduct(ID))){
                    System.out.println("1. go to shopping cart \n2. leave comment \n3. back to previous \n4. exit");
                    switch (scanner.nextInt()){
                        case 1:
                            customerPanel.shoppingCartPage(customer.getCart());
                            continue;
                        case 2:
                            leaveComment();
                            continue;
                        case 3:
                            return;
                        case 4:
                            System.exit(0);
                    }
                }
                System.out.println("1. add to shopping cart \n2. go to shopping cart \n3. leave comment \n4. back to previous \n5. exit");
                switch (scanner.nextInt()){
                    case 1:
                       customerPanel.addToShoppingCart(customer.getCart(), productController.findProduct(ID));
                        continue;
                    case 2:
                        customerPanel.shoppingCartPage(customer.getCart());
                        continue;
                    case 3:
                        leaveComment();
                        continue;
                    case 4:
                        return;
                    case 5:
                        System.exit(0);
                }
            }
        }
    }

    private void searchInProducts(){
        while(true){
            scanner.nextLine();
            System.out.println("product name: ");
            String ID=scanner.nextLine();
            if(productController.findMatches(ID).size()==0) System.out.println("no match result");
            else switchBetweenPages(productController.findMatches(ID));
            System.out.println("1. search again \n2. back to previous \n3. exit");
            switch (scanner.nextInt()){
                case 1:
                    continue;
                case 2:
                    return;
                case 3:
                    System.exit(0);
            }
        }
    }

    /*
    private void filterProducts(){
        System.out.println("filter by: \n1. general category \n2. price \n3. rate \n4. availability \n5. back to previous \n6. exit");
        switch (scanner.nextInt()){
            case 1:
                switchBetweenPages();
                System.out.println("1. data storage equipment \n2. PC \n3. price \n4. rate \n5. availability \n6. back to previous \n7. exit");
                scanner.nextLine();
                switch (scanner.nextLine()){
                    case "digital"
                }
                productController.filterByGeneralCategory(productController.getProducts(), )
        }
    }
     */

    private void leaveComment(){
        System.out.println("product ID: ");
        String ID=scanner.next();
        System.out.println("comment text: ");
        productController.commentToProduct(customer, ID, scanner.next());
        System.out.println("comment request sent successfully");
    }
}

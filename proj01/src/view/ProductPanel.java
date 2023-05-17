package view;

import controller.ProductController;
import model.product.*;
import model.user.Customer;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductPanel {
    private final Customer customer;
    private final ArrayList<Product> tempCart;
    private final ProductController productController;
    private final CustomerPanel customerPanel;
    private final Scanner scanner;

    public ProductPanel(Customer customer) {
        this.customer = customer;
        productController = ProductController.getInstance();
        scanner = new Scanner(System.in);
        tempCart = new ArrayList<>();
        customerPanel = new CustomerPanel(customer, tempCart);
    }

    public void showMenu() {
        while (true) {
            System.out.println("1. product page \n2. search product \n3. filter product \n4. back to previous \n5. exit");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    switchBetweenPages(productController.getProducts());
                    continue;
                case 2:
                    searchInProducts();
                    continue;
                case 3:
                    filterByGeneralCategory(productController.getProducts());
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void switchBetweenPages(ArrayList<Product> products) {
        System.out.println("number of product in each page: ");
        int numberInEachPage = scanner.nextInt(), i = 0;

        while (i < products.size()) {  //
            printEachPage(productController.divideProducts(products, numberInEachPage, i));

            if (numberInEachPage >= products.size()) {
                System.out.println("1. select \n2. back to previous \n3. exit");
                switch (scanner.nextInt()) {
                    case 1:
                        ProductSpecialPage();
                        continue;
                    case 2:
                        return;
                    case 3:
                        System.exit(0);
                }
            } else if (i == 0) {
                System.out.println("1. next \n2. select \n3. back to previous \n4. exit");
                switch (scanner.nextInt()) {
                    case 1:
                        i += numberInEachPage;
                        continue;
                    case 2:
                        ProductSpecialPage();
                        continue;
                    case 3:
                        return;
                    case 4:
                        System.exit(0);
                }
            } else if (i < products.size() - numberInEachPage) {
                System.out.println("1. next \n2. previous \n3. select \n4. back to previous \n5. exit");
                switch (scanner.nextInt()) {
                    case 1:
                        i += numberInEachPage;
                        continue;
                    case 2:
                        i -= numberInEachPage;
                        continue;
                    case 3:
                        ProductSpecialPage();
                        continue;
                    case 4:
                        return;
                    case 5:
                        System.exit(0);
                }
            } else {
                System.out.println("1. previous \n2. select \n3. back to previous \n4. exit");
                switch (scanner.nextInt()) {
                    case 1:
                        i -= numberInEachPage;
                        continue;
                    case 2:
                        ProductSpecialPage();
                        continue;
                    case 3:
                        return;
                    case 4:
                        System.exit(0);
                }
            }
        }
    }

    private void printEachPage(ArrayList<Product> productsInPage) {
        for (Product a : productsInPage)
            System.out.println("name: " + a.getName() + "\nprice: " + a.getPrice() + "\nID: " + a.getID() + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    private void ProductSpecialPage() {
        System.out.println("product ID: ");
        String ID = scanner.next();
        Product product = productController.findProduct(ID);
        if (customer == null) nullCustomerProductSpecialPage(product);
        else loggedInCustomerProductSpecialPage(product);
    }

    private void nullCustomerProductSpecialPage(Product product) {
        System.out.println(product.toString() + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
        while (true) {
            if (tempCart.contains(product)) {
                System.out.println("1. go to shopping cart \n2. back to previous \n3. exit");
                switch (scanner.nextInt()) {
                    case 1:
                        customerPanel.shoppingCartPage(tempCart);
                        continue;
                    case 2:
                        return;
                    case 3:
                        System.exit(0);
                }
            } else {
                System.out.println("1. add to shopping cart \n2. go to shopping cart \n3. back to previous \n4. exit");
                switch (scanner.nextInt()) {
                    case 1:
                        customerPanel.addToShoppingCart(tempCart, product);
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
    }

    private void loggedInCustomerProductSpecialPage(Product product) {
        System.out.println(product + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
        while (true) {
            if (customer.getCart().contains(product)) {
                System.out.println("1. go to shopping cart \n2. leave comment \n3. back to previous \n4. exit");
                switch (scanner.nextInt()) {
                    case 1:
                        customerPanel.shoppingCartPage(customer.getCart());
                        continue;
                    case 2:
                        leaveComment(product);
                        continue;
                    case 3:
                        return;
                    case 4:
                        System.exit(0);
                }
            }
            System.out.println("1. add to shopping cart \n2. go to shopping cart \n3. leave comment \n4. back to previous \n5. exit");
            switch (scanner.nextInt()) {
                case 1:
                    customerPanel.addToShoppingCart(customer.getCart(), product);
                    continue;
                case 2:
                    customerPanel.shoppingCartPage(customer.getCart());
                    continue;
                case 3:
                    leaveComment(product);
                    continue;
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void searchInProducts() {
        while (true) {
            System.out.println("product name: ");
            String name = scanner.next();
            if (productController.findMatches(name).size() == 0) System.out.println("no match result");
            else switchBetweenPages(productController.findMatches(name));
            System.out.println("1. search again \n2. back to previous \n3. exit");
            switch (scanner.nextInt()) {
                case 1:
                    continue;
                case 2:
                    return;
                case 3:
                    System.exit(0);
            }
        }
    }

    private void filterByGeneralCategory(ArrayList<Product> products) {
        ArrayList<Product> temp = new ArrayList<>(products);
        while (true) {
            print(temp);
            System.out.println("1. digital equipment \n2. stationary \n3. vehicle \n4. edible product \n5. skip \n6. back to previous \n7. exit");
            switch (scanner.nextInt()) {
                case 1:
                    filterDigitalEquipments(productController.filterByGeneralCategory(products, ProductCategory.DIGITAL_EQUIPMENT));
                    products = temp;
                    continue;
                case 2:
                    filterStationaryProducts(productController.filterByGeneralCategory(products, ProductCategory.STATIONERY));
                    products = temp;
                    continue;
                case 3:
                    filterVehicleProducts(productController.filterByGeneralCategory(products, ProductCategory.VEHICLE));
                    products = temp;
                    continue;
                case 4:
                    filterDigitalEquipments(productController.filterByGeneralCategory(products, ProductCategory.EDIBLE_PRODUCT));
                    products = temp;
                    continue;
                case 5:
                    filterByGeneralAttributes(products);
                    products = temp;
                    continue;
                case 6:
                    return;
                case 7:
                    System.exit(0);
            }
        }
    }

    private void filterDigitalEquipments(ArrayList<Product> products) {
        ArrayList<Product> temp = new ArrayList<>(products);
        while (true) {
            print(temp);
            System.out.println("1. data storage equipment \n2. pc \n3. skip \n4. back to previous \n5. exit");
            switch (scanner.nextInt()) {
                case 1:
                    filterDataStorageEquipments(productController.filterDataStorageEquipments(products));
                    products = temp;
                    continue;
                case 2:
                    System.out.println("ram capacity: ");
                    filterByGeneralAttributes(productController.filterRAMCapacity(productController.filterPCs(products), scanner.nextInt()));
                    products = temp;
                    continue;
                case 3:
                    filterByGeneralAttributes(products);
                    products = temp;
                    continue;
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void filterDataStorageEquipments(ArrayList<Product> products) {
        ArrayList<Product> temp = new ArrayList<>(products);
        while (true) {
            print(temp);
            System.out.println("1. flash memory \n2. ssd \n3. skip \n4. remove filter \n5. exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("USB version: ");
                    filterByGeneralAttributes(productController.filterUSBVersion(productController.filterFlashMemories(products), scanner.nextDouble()));
                    products = temp;
                    continue;
                case 2:
                    System.out.println("read speed: ");
                    filterByGeneralAttributes(productController.filterReadSpeed(productController.filterSSDs(products), scanner.nextInt()));
                    products = temp;
                    continue;
                case 3:
                    filterByGeneralAttributes(products);
                    products = temp;
                    continue;
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void filterStationaryProducts(ArrayList<Product> products) {
        ArrayList<Product> temp = new ArrayList<>(products);
        while (true) {
            print(temp);
            System.out.println("1. pencil \n2. pen \n3. note book \n4. skip \n5. remove filter \n6. exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("pencil type: ");
                    filterByGeneralAttributes(productController.filterPencilType(productController.filterPencils(products), PencilType.valueOf(scanner.next())));
                    products = temp;
                    break;
                case 2:
                    System.out.println("pen color: ");
                    filterByGeneralAttributes(productController.filterPenColor(productController.filterPens(products), PenColor.valueOf(scanner.next())));
                    products = temp;
                    continue;
                case 3:
                    System.out.println("number of pages: ");
                    filterByGeneralAttributes(productController.filterNumberOfPages(productController.filterNoteBooks(products), scanner.nextInt()));
                    products = temp;
                    break;
                case 4:
                    filterByGeneralAttributes(products);
                    products = temp;
                    continue;
                case 5:
                    return;
                case 6:
                    System.exit(0);
            }
        }
    }

    private void filterVehicleProducts(ArrayList<Product> products) {
        ArrayList<Product> temp = new ArrayList<>(products);
        while (true) {
            print(temp);
            System.out.println("1. bicycle \n2. car \n3. skip \n4. back to previous \n5. exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("bicycle type: ");
                    filterByGeneralAttributes(productController.filterBikeType(productController.filterBicycles(products), BikeType.valueOf(scanner.next())));
                    products = temp;
                    continue;
                case 2:
                    System.out.println("capacity: ");
                    filterByGeneralAttributes(productController.filterAutomatic(productController.filterCars(products), scanner.nextBoolean()));
                    products = temp;
                    continue;
                case 3:
                    filterByGeneralAttributes(products);
                    products = temp;
                    continue;
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void filterByGeneralAttributes(ArrayList<Product> products) {
        ArrayList<Product> temp = new ArrayList<>(products);
        while (true) {
            print(products);
            System.out.println("1. price \n2. availability \n3. back to previous \n4. exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("floor and ceil: ");
                    products = productController.filterByPrice(products, scanner.nextDouble(), scanner.nextDouble());
                    continue;
                case 2:
                    System.out.println("1. available \n2. unavailable");
                    if (scanner.nextInt() == 1) products = productController.filterBySupplyStatus(products, true);
                    else products = productController.filterBySupplyStatus(products, false);
                    continue;
                case 3:
                    return;
                case 4:
                    System.exit(0);
            }
        }
    }

    private void print(ArrayList<Product> products) {
        for (Product a : products)
            System.out.println("name: " + a.getName() + "\nprice: " + a.getPrice() + "\nID: " + a.getID() + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    private void leaveComment(Product product) {
        System.out.println("comment text: ");
        productController.commentToProduct(customer, product, scanner.next());
        System.out.println("comment request sent successfully");
    }
}

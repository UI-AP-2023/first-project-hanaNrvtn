package view;

import controller.AdminController;
import controller.CustomerController;
import model.product.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPanel {

    private final AdminController adminController;
    private final CustomerController customerController;
    private final Scanner scanner;

    public MainPanel() {
        adminController = AdminController.getInstance();
        customerController = CustomerController.getInstance();
        scanner = new Scanner(System.in);
    }

    public void mainPage() {
        while (true) {
            System.out.println("1. login \n2. sign up\n3. product page \n4. exit");
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> loginPage(new ArrayList<>());
                case 2 -> signUpPage();
                case 3 -> productsPage();
                case 4 -> System.exit(0);
            }
        }
    }

    public void loginPage(ArrayList<Product> tempSoppingCart) {
        while (true) {
            System.out.println("<login page>\nuser name:");
            String userName = scanner.next();
            System.out.println("password:");
            String password = scanner.next();
            if (adminController.login(userName, password)) {
                AdminPanel adminPanel = new AdminPanel();
                adminPanel.matchCommand();
                return;
            } else if (customerController.login(userName, password) != null) {
                CustomerPanel customerPanel = new CustomerPanel(customerController.login(userName, password), tempSoppingCart);
                customerPanel.showMenu();
                return;
            }
            System.out.println("invalid user name or password\n 1. try again\n 2. back to previous \n 3. exit");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    continue;
                case 2:
                    return;
                case 3:
                    System.exit(0);
            }
        }
    }

    private void signUpPage() {
        String userName, email, phoneNumber, password;
        System.out.println("<signup page>\nuser name: ");
        while (true) {
            userName = scanner.next();
            if (!customerController.checkUserNameAvailability(userName)) {
                System.out.println("email: ");
                break;
            }
            System.out.println("unavailable user name, try again");
        }

        while (true) {
            email = scanner.next();
            if (customerController.checkEmailRegex(email)) {
                System.out.println("invalid email, try again");
            } else if (customerController.checkEmailAvailability(email)) {
                System.out.println("unavailable email, try again");
            } else {
                System.out.println("phone number: ");
                break;
            }
        }

        while (true) {
            phoneNumber = scanner.next();
            if (customerController.checkPhoneNumberRegex(phoneNumber)) {
                System.out.println("invalid phone number, try again");
            } else if (customerController.checkPhoneNumberAvailability(phoneNumber)) {
                System.out.println("unavailable phone number, try again");
            } else {
                System.out.println("password: ");
                break;
            }
        }

        while (true) {
            password = scanner.next();
            if (customerController.checkPasswordRegex(password)) {
                System.out.println("invalid password, try again");
            } else break;
        }

        customerController.signup(userName, email, phoneNumber, password);
        System.out.println("registration request sent successfully \n1. back to previous \n2. exit");
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                return;
            case 2:
                System.exit(0);
        }
    }

    private void productsPage() {
        ProductPanel productPanel = new ProductPanel(null);
        productPanel.showMenu();
    }
}

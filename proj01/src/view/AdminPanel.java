package view;

import controller.AdminController;
import controller.CustomerController;
import model.product.DiscountCode;
import model.product.DiscountType;
import model.product.Product;
import model.user.*;

import java.time.LocalDate;
import java.util.Scanner;

public class AdminPanel {
    private final AdminController adminController;
    private final Scanner scanner;

    public AdminPanel() {
        adminController = AdminController.getInstance();
        scanner = new Scanner(System.in);
    }

    public AdminController getAdminController() {
        return adminController;
    }

    public void matchCommand() {
        while (true) {
            System.out.println("command: ");
            String command = scanner.nextLine();
            String[] splitCommand = command.split(" ", 2);
            switch (splitCommand[0]) {
                case "Add":
                    addProduct(splitCommand[1]);
                    break;
                case "Remove":
                    removeProduct(splitCommand[1]);
                    break;
                case "Edit":
                    editProduct(splitCommand[1]);
                    break;
                case "ShowAllRequests":
                    printAllRequest();
                    break;
                case "ManageRequest":
                    manageRequest(splitCommand[1]);
                    break;
                case "OfferDiscount":
                    offerDiscount(splitCommand[1]);
                    break;
                case "EditWelcomingDiscount":
                    editWelcomingDiscount(splitCommand[1]);
                    break;
                case "RemoveWelcomingDiscount":
                    removeWelcomingDiscount();
                    break;
                case "ApplyDiscount":
                    applyDiscount(splitCommand[1]);
                    break;
                case "RescindDiscount":
                    adminController.rescindDiscountOnProduct(splitCommand[1]);
                    break;
                case "ShowAllUsers":
                    printAllUsers();
                    break;
                case "ShowAllProducts":
                    printAllProducts();
                    break;
                case "Help":
                    printCommandS();
                    break;
                case "Back":
                    return;
                case "Exit":
                    System.exit(0);
                default:
                    System.out.println("wrong command");
            }
        }
    }

    private void applyDiscount(String remainCommand) {
        String[] strings = remainCommand.split(" ");
        try {
            adminController.applyDiscountOnProduct(Double.parseDouble(strings[0]), Integer.parseInt(strings[1]), strings[2]);
        }catch (NullPointerException nullPointerException){
            System.out.println("product not found");
        }
    }

    private void offerDiscount(String remainCommand){
        String[] strings = remainCommand.split(" ");
        switch (strings[0]) {
            case "welcoming" -> adminController.setSampleDiscountCode(new DiscountCode(Double.parseDouble(strings[1]), LocalDate.parse(strings[2]), Integer.parseInt(strings[3]), DiscountType.WELCOMING));
            case "Encouraging" -> adminController.offerEncouragingDiscount(Double.parseDouble(strings[1]), LocalDate.parse(strings[2]), Integer.parseInt(strings[3]));
            case "Loyalty" -> adminController.offerLoyaltyDiscount(Double.parseDouble(strings[1]), LocalDate.parse(strings[2]), Integer.parseInt(strings[3]));
        }
        System.out.println("offered successfully");
    }

    private void removeWelcomingDiscount(){
        adminController.removeWelcomingDiscount();
        System.out.println("removed successfully");
    }

    private void editWelcomingDiscount(String remainCommand){
        String[] strings = remainCommand.split(" ");
        adminController.editWelcomingDiscount(Double.parseDouble(strings[0]), LocalDate.parse(strings[1]), Integer.parseInt(strings[2]));
        System.out.println("edited successfully");
    }

    private void addProduct(String remainCommand) {
        String[] strings = remainCommand.split(" ");
        switch (strings[0]) {
            case "FlashMemory" -> adminController.addFlashMemory(Double.parseDouble(strings[1]), Integer.parseInt(strings[2]), Double.parseDouble(strings[3]), strings[4], strings[5], Integer.parseInt(strings[6]), Integer.parseInt(strings[7]));
            case "SSD" -> adminController.addSSD(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), Double.parseDouble(strings[4]), strings[5], strings[6], Integer.parseInt(strings[7]), Integer.parseInt(strings[8]));
            case "PC" -> adminController.addPC(strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]), strings[4], strings[5], Integer.parseInt(strings[6]), Integer.parseInt(strings[7]));
            case "Pencil" -> adminController.addPencil(strings[1], strings[2], strings[3], Integer.parseInt(strings[4]), Integer.parseInt(strings[5]));
            case "Pen" -> adminController.addPen(strings[1], strings[2], strings[3], Integer.parseInt(strings[4]), Integer.parseInt(strings[5]));
            case "NoteBook" -> adminController.addNoteBook(Integer.parseInt(strings[1]), strings[2], strings[3], strings[4], Integer.parseInt(strings[5]), Integer.parseInt(strings[6]));
            case "Bicycle" -> adminController.addBicycle(strings[1], strings[2], strings[3], Integer.parseInt(strings[4]), Integer.parseInt(strings[5]));
            case "Car" -> adminController.addCar(Integer.parseInt(strings[1]), Boolean.parseBoolean(strings[2]), strings[3], strings[4], Integer.parseInt(strings[5]), Integer.parseInt(strings[6]));
            case "EdibleProduct" -> adminController.addEdibleProduct(strings[1], strings[2], strings[3], Integer.parseInt(strings[4]), Integer.parseInt(strings[5]));
        }
        System.out.println("added successfully");
    }

    private void removeProduct(String remainCommand) {
        System.out.println(adminController.removeProduct(remainCommand) ? "removed successfully" : "product not found");
    }

    private void editProduct(String remainCommand) {
        String[] strings = remainCommand.split(" ");
        switch (strings[1]) {
            case "Name" -> System.out.println(adminController.editProductName(strings[0], strings[2]) ? "edited successfully" : "product not found");
            case "Price" -> System.out.println(adminController.editProductPrice(strings[0], Integer.parseInt(strings[2])) ? "edited successfully" : "product not found");
            case "Supply" -> System.out.println(adminController.editNumberOfProduct(strings[1], Integer.parseInt(strings[2])) ? "edited successfully" : "product not found");
            default -> System.out.println("invalid attribute");
        }
    }

    private void printAllUsers() {
        for (User a : adminController.showAllUsers())
            System.out.println(a.toString());
    }

    private void printAllProducts() {
        for (Product a : adminController.showAllProducts())
            System.out.println(a.toString() + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    private void printAllRequest() {
        System.out.println("registration requests: ");
        if (adminController.showAllRegistrationRequests().size() == 0) System.out.println("no request yet");
        adminController.showAllRegistrationRequests().forEach(n -> System.out.println("user: " + n.getCustomer().getUserName()));
        System.out.println("\ncomment check requests: ");
        if (adminController.showAllCommentCheckRequests().size() == 0) System.out.println("no request yet");
        adminController.showAllCommentCheckRequests().forEach(n -> System.out.println("user: " + n.getComment().getUser().getUserName()));
        System.out.println("\nincrease credit requests: ");
        if (adminController.showAllIncreaseCreditRequests().size() == 0) System.out.println("no request yet");
        adminController.showAllIncreaseCreditRequests().forEach(n -> System.out.println("user: " + n.getCustomer().getUserName()));
    }

    private void manageRequest(String remainCommand) {
        String[] strings = remainCommand.split(" ", 2);
        switch (strings[0]) {
            case "Accept" -> acceptRequests(strings[1]);
            case "Reject" -> rejectRequest(strings[1]);
        }
    }

    private void acceptRequests(String remainString) {
        String[] strings = remainString.split(" ");
        Request request;
        switch (strings[0]) {
            case "Registration" -> {
                request = adminController.findRequest(RequestType.REGISTRATION_REQUEST, strings[1]);
                if (request == null || !adminController.acceptRegistrationRequest(request))
                    System.out.println("not found");
                else System.out.println("accepted successfully");
            }
            case "CommentCheck" -> {
                request = adminController.findRequest(RequestType.COMMENT_CHECK_REQUEST, strings[1]);
                if (request != null) {
                    System.out.println(adminController.acceptCommentCheckRequest(request) ? "accepted successfully" : "rejected successfully");
                } else
                    System.out.println("request not found");
            }
            case "CreditIncrease" -> {
                request = adminController.findRequest(RequestType.CREDIT_INCREASE_REQUEST, strings[1]);
                if (request != null) {
                    System.out.println(adminController.acceptIncreaseCreditRequest(request) ? "accepted successfully" : "rejected successfully");
                } else
                    System.out.println("request not found");
            }
        }
    }

    private void rejectRequest(String remainRequest) {
        String[] strings = remainRequest.split(" ");
        switch (strings[0]) {
            case "Registration" -> System.out.println(adminController.rejectRegistrationRequest(adminController.findRequest(RequestType.REGISTRATION_REQUEST, strings[1])) ? "removed successfully" : "request not found");
            case "CommentCheck" -> System.out.println(adminController.rejectCommentCheckRequest(adminController.findRequest(RequestType.CREDIT_INCREASE_REQUEST, strings[1])) ? "rejected successfully" : "request not found");
            case "CreditIncrease" -> System.out.println(adminController.rejectIncreaseCreditRequest(adminController.findRequest(RequestType.CREDIT_INCREASE_REQUEST, strings[1])) ? "rejected successfully" : "request not found");
        }
    }

    private void printCommandS() {
        System.out.println("H");
        System.out.println(
                """
                        Add:
                        Add FlashMemory USBVersion capacity weight dimension name price numberOfProduct
                        Add SSD readSpeed WriteSpeed capacity weight dimension name price numberOfProduct
                        Add PC CPUModel RAMCapacity weight dimension name price numberOfProduct
                        Add Pencil type manufacturingCountry name price numberOfProduct
                        Add Pen color manufacturingCountry name price numberOfProduct
                        Add NoteBook numberOfPages paperType manufacturingCountry name price numberOfProduct
                        Add Bicycle type manufacturer name price numberOfProduct
                        Add Car motorCapacity isAutomatic manufacturer name price numberOfProduct
                        Add EdibleProduct productionDate expirationDate name price numberOfProduct
                        Remove:
                        Remove ID
                        Edit:
                        Edit ID editingAttribute newValue
                        ShowAllRequests
                        ManageRequest Accept/Reject RequestType(Registration/CommentCheck/CreditIncrease) userName
                        OfferDiscount DiscountType(Welcoming, Encouraging, Loyalty) Percentage Expiration Capacity
                        EditWelcomingDiscount Percentage Expiration Capacity
                        RemoveWelcomingDiscount
                        ApplyDiscount Percentage Capacity ProductID
                        RescindDiscount ProductID
                        ShowAllUsers
                        Help
                        Back
                        Exit""");
    }
}

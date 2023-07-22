package com.example.firstproj02.model.accounts;

import com.example.firstproj02.model.processes.Comment;
import com.example.firstproj02.model.processes.CommentCheckRequest;
import com.example.firstproj02.model.processes.RegistrationRequest;
import com.example.firstproj02.model.processes.Request;
import com.example.firstproj02.model.products.*;

import java.util.ArrayList;

public class Admin extends User {
    public static Admin admin;
    private final ArrayList<Product> products;
    private final ArrayList<Request> requests;

    private Admin(String userName, String email, String phoneNumber, String password) {
        super(userName, email, phoneNumber, password);
        products = new ArrayList<>();
        requests = new ArrayList<>();

        FlashMemory flashMemory1 = new FlashMemory(2.0, 8, 10, "22:12:5", "QUICK C-PLUS", 16, 50);
        FlashMemory flashMemory2 = new FlashMemory(1.0, 16, 10, "12:10:8", "Micro Sonic", 30, 200);
        FlashMemory flashMemory3 = new FlashMemory(2.0, 16, 12, "12:12:5", "Ultra Drive", 20, 72);
        FlashMemory flashMemory5 = new FlashMemory(3.0, 32, 10, "20:8:4", "Cruzer CZ50", 15, 78);
        FlashMemory flashMemory6 = new FlashMemory(3.0, 32, 10, "20:8:4", "San Disk M3.0", 40, 78);
        FlashMemory flashMemory7 = new FlashMemory(3.0, 32, 10, "20:8:4", "Cruzer CZ50", 34, 78);

        SSD ssd1 = new SSD(1350, 1500, 500, 200, "20:20:5", "SSD EVO 870", 100, 90);
        SSD ssd2 = new SSD(1400, 1400, 500, 300, "20:10:5", "SSD 70 EVO PLUS", 80, 90);
        SSD ssd3 = new SSD(1000, 1550, 300, 260, "25:10:5", "SSD SU650", 65, 90);
        SSD ssd4 = new SSD(1300, 1450, 1000, 260, "20:20:5", "SSD SPATIUM M390 NVMe M.2 ", 96, 90);

        PC pc1 = new PC("Core i7", 8, 3000, "50:40:12", "iMac MXWV2 2020", 879, 10);
        PC pc2 = new PC("Core i5", 16, 3500, "50:40:12", "PC SHARK FK", 1000, 10);
        PC pc3 = new PC("Core i7", 16, 35600, "50:40:12", "PC ZN240-C38SB", 1600, 100);
        PC pc4 = new PC("Core i7", 8, 3000, "50:40:12", "PC Pavilion 27-CA1066-A", 1390, 150);

        Car car1 = new Car(100, true, "China", "HIMA S7", 13000, 400);
        Car car2 = new Car(150, false, "US", "Lincoln", 50000, 50);
        Car car3 = new Car(100, false, "China", "MVM X22", 18000, 100);
        Car car4 = new Car(100, true, "US", "Lexus GX", 70000, 200);
        Car car5 = new Car(100, true, "US", "Acura ZDX", 70000, 200);
        Car car6 = new Car(100, true, "US", "2KIA CERATO", 120000, 200);
        Car car7 = new Car(100, true, "US", "Mercedes EQT", 50000, 200);
        Car car8 = new Car(100, true, "US", "Mazda CX90", 400000, 200);
        Car car9 = new Car(100, true, "US", "Fiat 500e", 400000, 200);
        Car car10 = new Car(100, true, "US", "Peugeot 208", 350000, 200);
        Car car11 = new Car(100, true, "US", "Suzuki VXI", 10000, 200);
        Car car12 = new Car(100, true, "US", "Bugatti 2020", 50000, 200);
        Car car13 = new Car(100, true, "US", "Hyundai", 10000, 200);
        Car car14 = new Car(100, true, "US", "Tata XE", 9000, 200);
        Car car15 = new Car(100, true, "US", "Nissan Micra", 9900, 200);
        Car car16 = new Car(100, true, "US", "Citroen C3", 9700, 200);
        Car car17 = new Car(100, true, "US", "Suzuki RZXI", 9600, 200);
        Car car18 = new Car(100, true, "US", "Chery EQ1", 9400, 200);
        Car car19 = new Car(100, true, "US", "Ford Figo", 9300, 200);
        Car car20 = new Car(100, true, "US", "Hyundai i10", 9300, 200);
        Car car21 = new Car(100, true, "US", "Mazda TZ90", 9200, 200);

        NoteBook noteBook1 = new NoteBook(90, "glossy", "Iran", "azi Book", 90, 90);
        NoteBook noteBook2 = new NoteBook(90, "glossy", "China", "Zen Note", 90, 90);
        NoteBook noteBook3 = new NoteBook(90, "glossy", "Germany", "Ghoefhel", 90, 90);
        NoteBook noteBook4 = new NoteBook(90, "flaxen", "Russia", "Unique Notes", 90, 90);
        NoteBook noteBook5 = new NoteBook(90, "flaxen", "UK", "GoldenBook", 90, 90);

        Pen pen1 = new Pen("blue", "Germany", "X3", 3, 200);
        Pen pen2 = new Pen("black", "France", "Faber Catel", 2, 200);
        Pen pen3 = new Pen("blue", "Iran", "Kian", 3, 200);
        Pen pen4 = new Pen("red", "US", "bik", 3, 200);

        Pencil pencil1 = new Pencil("H", "France", "Fabel Castel", 1, 500);
        Pencil pencil2 = new Pencil("HB", "Iran", "LakPoshtIrani", 2, 500);

        EdibleProduct edibleProduct = new EdibleProduct("12", "2", "edibel product", 90, 90);

        products.add(noteBook1);
        products.add(noteBook2);
        products.add(noteBook3);
        products.add(noteBook4);
        products.add(noteBook5);
        products.add(pen1);
        products.add(pen2);
        products.add(pen3);
        products.add(pen4);
        products.add(pencil1);
        products.add(pencil2);

        products.add(flashMemory1);
        products.add(flashMemory2);
        products.add(flashMemory3);
        products.add(car1);
        products.add(car2);
        products.add(car3);
        products.add(car4);
        products.add(car5);
        products.add(car6);
        products.add(car7);
        products.add(car8);
        products.add(car9);
        products.add(car10);
        products.add(car11);
        products.add(car12);
        products.add(car13);
        products.add(car14);
        products.add(car15);
        products.add(car16);
        products.add(car17);
        products.add(car18);
        products.add(car19);
        products.add(car20);
        products.add(car21);

        products.add(flashMemory5);
        products.add(flashMemory6);
        products.add(flashMemory7);
        products.add(ssd1);
        products.add(ssd2);
        products.add(ssd3);
        products.add(ssd4);
        products.add(pc1);
        products.add(pc2);
        products.add(pc3);
        products.add(pc4);

        products.add(edibleProduct);

        Customer customer = new Customer("ahmad", "ahmad@gmail.com", "09121119090", "1234");
        requests.add(new RegistrationRequest(customer));
        Customer customer1 = new Customer("ahmad1", "ahmad1@gmail.com", "09121119090", "12345");
        requests.add(new RegistrationRequest(customer1));

        Comment comment = new Comment(customer, "kdls", "highly recommen kldkf \n kldkf \n jksdj", true);
        requests.add(new CommentCheckRequest(comment));
    }

    public static Admin getInstance(String userName, String email, String phoneNumber, String password) {
        if (admin == null) admin = new Admin(userName, email, phoneNumber, password);
        return admin;
    }

    public static Admin getAdmin() {
        return admin;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

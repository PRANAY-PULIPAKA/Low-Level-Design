package InterviewProblems.InventoryManagementSystem.Extention;

import InterviewProblems.InventoryManagementSystem.Product;

public class InventoryDemo {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addObserver(new EmailAlertObserver());

        Product p1 = new Product("P101", "Laptop", 75000);
        inventory.addProduct(p1, 7);

        inventory.reserveProduct("P101", 3);
        inventory.reserveProduct("P101", 2); // LOW STOCK TRIGGER
    }
}

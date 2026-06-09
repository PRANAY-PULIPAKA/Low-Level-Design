package StructuralDesignPatterns.DecoraterDesignPattern.BadPractice;

import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your coffee order");
        String coffeeOrder = scanner.nextLine();
        if(coffeeOrder.equalsIgnoreCase("Espresso with Milk and Sugar")){
            System.out.println("Preparing Espresso with Milk and Sugar...");
        } else if (coffeeOrder.equalsIgnoreCase("Cappuccino with Vanilla")) {
            System.out.println("Preparing Cappuccino with Vanilla...");
        } else {
            System.out.println("Order not recognized!");
        }
        scanner.close();
    }
}

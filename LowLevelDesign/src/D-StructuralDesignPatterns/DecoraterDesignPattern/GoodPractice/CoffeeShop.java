package StructuralDesignPatterns.DecoraterDesignPattern.GoodPractice;

public class CoffeeShop {
    public static void main(String[] args) {

        Coffee coffee = new Espresso();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        System.out.println("Order "+ coffee.description());
        System.out.println("Total cost: $" + coffee.getCost());
    }
}

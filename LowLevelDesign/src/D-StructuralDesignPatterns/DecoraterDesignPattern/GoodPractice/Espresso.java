package StructuralDesignPatterns.DecoraterDesignPattern.GoodPractice;

public class Espresso implements Coffee{
    @Override
    public String description() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 2.00;
    }
}

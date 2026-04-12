package StructuralDesignPatterns.DecoraterDesignPattern.GoodPractice;

public class Cappucino implements Coffee{
    @Override
    public String description() {
        return "Cappucino";
    }

    @Override
    public double getCost() {
        return 3.00;
    }
}

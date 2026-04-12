package StructuralDesignPatterns.DecoraterDesignPattern.GoodPractice;

public abstract class CoffeeDecorator implements Coffee{

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String description() {
        return coffee.description();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

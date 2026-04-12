package StructuralDesignPatterns.DecoraterDesignPattern.GoodPractice;

public class VanillaDecorator extends CoffeeDecorator{

    public VanillaDecorator(Coffee coffee){
        super(coffee);
    }

    public String description(){
        return coffee.description()+ ", Vanilla";
    }

    public double getCost(){
        return coffee.getCost()+ 0.75;
    }
}



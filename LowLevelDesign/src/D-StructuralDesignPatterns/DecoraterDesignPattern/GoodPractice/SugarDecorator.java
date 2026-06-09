package StructuralDesignPatterns.DecoraterDesignPattern.GoodPractice;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee){
        super(coffee);
    }

    public String description(){
        return coffee.description() + ", sugar";
    }

    public  double getCost(){
        return coffee.getCost() + 0.25;
    }
}

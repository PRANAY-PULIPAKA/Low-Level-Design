package StructuralDesignPatterns.DecoraterDesignPattern.GoodPractice;

public class MilkDecorator extends  CoffeeDecorator{

    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    public String description(){
        return coffee.description() + ", Milk";
    }

    public  double getCost(){
        return coffee.getCost() + 0.50;
    }

}

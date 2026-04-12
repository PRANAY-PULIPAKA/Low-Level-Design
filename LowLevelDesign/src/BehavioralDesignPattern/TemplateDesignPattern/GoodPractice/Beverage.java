package BehavioralDesignPattern.TemplateDesignPattern.GoodPractice;

public abstract class Beverage {
    public void prepare(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    //common methods
    void boilWater(){
        System.out.println("Boiling Water");
    }
    void pourInCup(){
        System.out.println("Pouring water");
    }
    //steps to be customized by subClasses
    abstract void brew();
    abstract  void addCondiments();

}

class Coffee extends Beverage{

    @Override
    void brew() {
        System.out.println("Brewing coffee..");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk..");
    }
}

class TeaBeverage extends Beverage{

    @Override
    void brew() {
        System.out.println("Steeping tea bag..");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon..");
    }
}

package BehavioralDesignPattern.TemplateDesignPattern.BadPractice;

public class Coffee {

    public void prepare(){
        boilWater();
        brewCoffee();
        pourInCup();
        addSugarAndMilk();
    }

    private void boilWater() {
        System.out.println("Boiling Water....");
    }

    private void brewCoffee() {
        System.out.println("Brewing Coffee");
    }

    private void pourInCup() {
        System.out.println("Pouring into Cup");
    }

    private void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }

}

class Tea{

    public void prepare(){
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    private void boilWater() {
        System.out.println("Boiling water..");
    }

    private void steepTeaBag() {
        System.out.println("Steeping Tea Bag..");
    }

    private void pourInCup() {
        System.out.println("Pouring into Cup..");
    }

    private void addLemon() {
        System.out.println("Adding Lemon..");
    }


}

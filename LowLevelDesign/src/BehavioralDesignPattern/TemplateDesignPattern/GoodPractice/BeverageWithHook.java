package BehavioralDesignPattern.TemplateDesignPattern.GoodPractice;

public abstract class BeverageWithHook {
    public void prepare() {
        boilWater();
        brew();
        pourInCup();

        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("Boiling Water..");
    }

    void pourInCup() {
        System.out.println("Pouring in cup..");
    }

    abstract void brew();

    abstract void addCondiments();

    boolean customerWantsCondiments() {
        return true;
    }
}

    class CustomCoffee extends BeverageWithHook{

        @Override
        void brew() {
            System.out.println("Brewing coffee..");
        }

        @Override
        void addCondiments() {
            System.out.println("Adding sugar and Milk..");
        }

        @Override
        boolean customerWantsCondiments(){
           return false;
        }
}

class BeverageWithHookDemo {

    public static void main(String[] args) {
        BeverageWithHook coffee = new CustomCoffee();
        coffee.prepare();
        System.out.println("Preparing coffee..");
    }
}

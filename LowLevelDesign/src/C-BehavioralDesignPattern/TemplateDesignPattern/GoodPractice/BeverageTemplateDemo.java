package BehavioralDesignPattern.TemplateDesignPattern.GoodPractice;

public class BeverageTemplateDemo {
    public static void main(String[] args) {
        Beverage coffee =  new Coffee();
        coffee.prepare();
        System.out.println("Making coffee..");

        Beverage tea = new TeaBeverage();
        tea.prepare();
        System.out.println("Making Tea..");
    }
}

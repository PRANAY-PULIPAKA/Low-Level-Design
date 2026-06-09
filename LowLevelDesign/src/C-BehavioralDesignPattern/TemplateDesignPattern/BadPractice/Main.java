package BehavioralDesignPattern.TemplateDesignPattern.BadPractice;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.prepare();
        System.out.println("Making coffee..");

        Tea tea = new Tea();
        tea.prepare();
        System.out.println("Making Tea..");
    }
}

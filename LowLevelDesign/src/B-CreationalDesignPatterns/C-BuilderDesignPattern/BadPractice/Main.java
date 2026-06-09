package CreationalDesignPatterns.BuilderDesignPattern.BadPractice;

public class Main {
    public static void main(String[] args) {

        /////Lack of readability////////////////
        //what is true, what is false
        ///what if more attributes need to be added, another new constructor?

        Car car = new Car("V8", 4, 5, "Red", true, false);
    }
}

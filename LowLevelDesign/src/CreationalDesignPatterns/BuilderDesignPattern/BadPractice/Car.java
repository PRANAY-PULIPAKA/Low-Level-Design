package CreationalDesignPatterns.BuilderDesignPattern.BadPractice;

public class Car {
    private String engine;
    private int wheels;
    private int seats;
    private String color;
    private boolean sunroof;
    private boolean navigationSystem;

    //Here even of attributes are not required programmer needs to use the default values
    public Car(String engine, int wheels, int seats, String color,
               boolean sunroof, boolean navigationSystem) {
        this.engine = engine;
        this.wheels = wheels;
        this.seats = seats;
        this.color = color;
        this.sunroof = sunroof;
        this.navigationSystem = navigationSystem;
    }

    // Constructor over loading for different parameters
    public Car(String engine, int wheels, int seats, String color) {
    //...
    }
    public Car(String engine, int wheels, int seats) {
    //...
    }
}
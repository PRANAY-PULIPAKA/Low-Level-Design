package CreationalDesignPatterns.FactoryDesignPattern.BadPractice;

public class Main {

    public static void main(String [] args){
        Vehicle vehicle1 = new Car();
        vehicle1.start();
        vehicle1.stop();

        Vehicle vehicle2 = new Truck();
        vehicle2.start();
        vehicle2.stop();

        Vehicle vehicle3 = new Bike();
        vehicle3.start();
        vehicle3.stop();
    }
}

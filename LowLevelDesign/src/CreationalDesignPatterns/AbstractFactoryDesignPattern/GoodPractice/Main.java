package CreationalDesignPatterns.AbstractFactoryDesignPattern.GoodPractice;

public class Main {

    public static void main(String[] args) {
        VehicleFactory hondaFactory = new HondaFactory();
        Vehicle honda = hondaFactory.createVehicle();
        honda.start();
        honda.stop();

    }

}

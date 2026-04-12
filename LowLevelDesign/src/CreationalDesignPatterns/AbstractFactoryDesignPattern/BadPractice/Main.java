package CreationalDesignPatterns.AbstractFactoryDesignPattern.BadPractice;

public class Main {

    public static void main(String [] args){

        CarFactory factory = new CarFactory();
        Vehicle vehicle = factory.createVehicle("Honda");
        vehicle.start();
        vehicle.stop();
    }
}

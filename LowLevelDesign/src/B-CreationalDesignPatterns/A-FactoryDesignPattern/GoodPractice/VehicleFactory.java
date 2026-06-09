package CreationalDesignPatterns.FactoryDesignPattern.GoodPractice;

public class VehicleFactory {

    public static Vehicle getVehicle(String VehicleType){

        if(VehicleType.equals("Car")){
            return new Car();
        } else if(VehicleType.equals("Truck")){
            return new Truck();
        } else if(VehicleType.equals("Bike")){
            return new Bike();
        } else{
            throw new IllegalArgumentException("Unknown Vehicle Type");
        }

    }
}

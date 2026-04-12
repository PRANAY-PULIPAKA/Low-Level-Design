package CreationalDesignPatterns.AbstractFactoryDesignPattern.GoodPractice;

public interface VehicleFactory {
    Vehicle createVehicle();
}

class HondaFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Honda();
    }
}

class ToyotaFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Toyota();
    }
}
class BMWFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new BMW();
    }
}

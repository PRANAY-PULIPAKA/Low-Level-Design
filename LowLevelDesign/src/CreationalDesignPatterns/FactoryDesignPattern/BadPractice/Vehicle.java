package CreationalDesignPatterns.FactoryDesignPattern.BadPractice;

public interface Vehicle {

    void start();
    void stop();
}

class Car implements Vehicle{
    public void start(){
        System.out.println("car started");
    }

    public void stop(){
        System.out.println("Car stopped");
    }
}

class Truck implements Vehicle{
    public void start(){
        System.out.println("Truck started");
    }

    public void stop(){
        System.out.println("Truck stopped");
    }
}

class Bike implements Vehicle{
    public void start(){
        System.out.println("Bike started");
    }

    public void stop(){
        System.out.println("Bike stopped");
    }
}

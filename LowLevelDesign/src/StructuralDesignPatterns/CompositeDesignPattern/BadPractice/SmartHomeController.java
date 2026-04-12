package StructuralDesignPatterns.CompositeDesignPattern.BadPractice;

public class SmartHomeController {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        SmartLight smartLight = new SmartLight();
        System.out.println("Turning ON devices in Room 1...");
        airConditioner.turnOn();
        smartLight.turnOn();
        System.out.println("Turning OFF devices in Room 1...");
        airConditioner.turnOff();
        smartLight.turnOff();
        // Manually managing multiple rooms
        System.out.println("Turning ON devices in Floor 1...");
        airConditioner.turnOn();
        smartLight.turnOn();
        airConditioner.turnOn(); // Room 2
        smartLight.turnOn(); // Room 2
        System.out.println("Turning OFF devices in Floor 2...");
        airConditioner.turnOff();
        smartLight.turnOff();
        airConditioner.turnOff(); // Room 3
        smartLight.turnOff(); // Room 3
        System.out.println("Turning ON all devices in the house...");
        airConditioner.turnOn();
        smartLight.turnOn();
    }
}

class AirConditioner {
    void turnOn(){

    }
    void turnOff(){

    }

}

class SmartLight{
    void turnOn(){

    }
    void turnOff(){

    }
}

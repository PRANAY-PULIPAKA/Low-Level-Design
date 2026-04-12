package StructuralDesignPatterns.AdapterDesignPattern.GoodPractice;

public class SmartHomeController {
    public static void main(String[] args) {
        // Create adapters for each device
        SmartDevice airConditioner =
                new AirConditionerAdapter(new AirConditioner());
        SmartDevice smartLight = new SmartLightAdapter(new SmartLight());
        SmartDevice coffeeMachine = new CoffeeMachineAdapter(new CoffeeMachine());
        // Control devices through the unified interface
        airConditioner.turnOn();
        smartLight.turnOn();
        coffeeMachine.turnOn();
        airConditioner.turnOff();
        smartLight.turnOff();
        coffeeMachine.turnOff();
    }
}

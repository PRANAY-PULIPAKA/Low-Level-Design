package StructuralDesignPatterns.CompositeDesignPattern.GoodPractice;

public class SmartHomeController {

    public static void main(String[] args) {
        SmartComponent airConditioner =  new AirConditioner();
        SmartComponent smartLight = new SmartLight();

        CompositeSmartComponent room1 = new CompositeSmartComponent();
        room1.addComponent(airConditioner);
        room1.addComponent(smartLight);

        CompositeSmartComponent room2 = new CompositeSmartComponent();
        room2.addComponent(airConditioner);
        room2.addComponent(smartLight);


        CompositeSmartComponent floor = new CompositeSmartComponent();
        floor.addComponent(room1);
        floor.addComponent(room2);

        CompositeSmartComponent house = new CompositeSmartComponent();
        house.addComponent(floor);

        // Control the entire house
        System.out.println("Turning ON all devices in the house:");
        house.turnOn();
        System.out.println("nTurning OFF all devices in the house:");
        house.turnOff();
        // Control a single floor
        System.out.println("nTurning ON all devices on the first floor:");
        floor.turnOn();
        System.out.println("nTurning OFF all devices on the first floor:");
        floor.turnOff();
        // Control a single room
        System.out.println("nTurning ON all devices in Room 1:");
        room1.turnOn();
        System.out.println("nTurning OFF all devices in Room 1:");
        room1.turnOff();

    }
}

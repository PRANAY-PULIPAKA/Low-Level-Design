package BehavioralDesignPattern.StateDesignPattern.GoodPractice;

import BehavioralDesignPattern.StateDesignPattern.BadPractice.TrafficLight;

public class RedState implements TrafficLightState {
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from RED TO GREEN. Cars Go!" );
        context.setState(new GreenState());
    }
    @Override
    public String getColor() {
        return "RED";
    }
}

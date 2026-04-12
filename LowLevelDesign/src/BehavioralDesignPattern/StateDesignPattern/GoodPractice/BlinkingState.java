package BehavioralDesignPattern.StateDesignPattern.GoodPractice;

public class BlinkingState implements TrafficLightState{
    public void next(TrafficLightContext context) {
        System.out.println("Switching from BLINKING to MAINTENANCE mode...");
        context.setState(new MaintenanceState());
    }
    @Override
    public String getColor() {
        return "BLINKING";
    }
}

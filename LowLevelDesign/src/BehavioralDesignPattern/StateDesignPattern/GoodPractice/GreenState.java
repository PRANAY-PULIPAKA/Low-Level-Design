package BehavioralDesignPattern.StateDesignPattern.GoodPractice;

public class GreenState implements  TrafficLightState{
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from GREEN to YELLOW. Slow down!");
        context.setState(new YellowState());
    }
    @Override
    public String getColor() {
        return "GREEN";
    }
}

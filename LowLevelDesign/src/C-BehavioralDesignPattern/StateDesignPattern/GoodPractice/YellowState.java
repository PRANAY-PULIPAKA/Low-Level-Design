package BehavioralDesignPattern.StateDesignPattern.GoodPractice;

public class YellowState implements TrafficLightState{
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from YELLOW TO RED. Cars Stop!");
        context.setState(new RedState());
    }
    @Override
    public String getColor() {
        return "YELLOW";
    }
}

package BehavioralDesignPattern.StateDesignPattern.GoodPractice;

public class MaintenanceState implements TrafficLightState {
        @Override
        public void next(TrafficLightContext context) {
            System.out.println("Maintenance done, back to RED!");
            context.setState(new RedState());
        }
        @Override
        public String getColor() {
            return "MAINTENANCE";
        }
}

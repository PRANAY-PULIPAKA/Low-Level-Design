package InterviewProblems.Elevator;

import java.util.ArrayList;
import java.util.Arrays;

public class Building {

    public static void main(String[] args) {

        Elevator e1 = new Elevator(1);
        Elevator e2 = new Elevator(2);

        ElevatorController controller = new ElevatorController(Arrays.asList(e1, e2));

        controller.handleRequest(new Request(5, Direction.UP));
        controller.handleRequest(new Request(2, Direction.DOWN));

        controller.step();
    }
}

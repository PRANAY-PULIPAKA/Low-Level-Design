package InterviewProblems.Elevator;

import java.util.List;

public class ElevatorController {

    private List<Elevator> elevators;

    public ElevatorController(List<Elevator> elevators){
        this.elevators = elevators;
    }

    public void handleRequest(Request request){
        Elevator bestElevator = findBestElevator(request);
        bestElevator.addRequest(request.getFloor());
    }
    private Elevator findBestElevator(Request request){
        Elevator result = null;
        int minDistance = Integer.MAX_VALUE;

        for(Elevator elevator : elevators){
            int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());

            if(distance < minDistance){
                    minDistance = distance;
                    result = elevator;
            }
        }
        return result;
    }

    public void step(){
        for( Elevator elevator : elevators){
            elevator.move();
        }
    }
}

package InterviewProblems.Elevator.Extention;

import InterviewProblems.Elevator.Direction;
import InterviewProblems.Elevator.ElevatorState;

import java.util.PriorityQueue;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private ElevatorMode mode = ElevatorMode.NORMAL;

    private PriorityQueue<Integer> upQueue =
            new PriorityQueue<>();
    private PriorityQueue<Integer> downQueue =
            new PriorityQueue<>((a, b) -> b - a);

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.STOPPED;
    }

    public void addRequest(Request request) {

        if (request.getType() == RequestType.EMERGENCY) {
            handleEmergency(request.getFloor());
            return;
        }

        if (mode == ElevatorMode.EMERGENCY) {
            // Ignore all other requests
            return;
        }

        if (request.getFloor() > currentFloor) {
            upQueue.offer(request.getFloor());
        } else {
            downQueue.offer(request.getFloor());
        }
    }

    private void handleEmergency(int targetFloor) {
        System.out.println("🚨 Emergency triggered in Elevator " + id);

        // Clear all existing requests
        upQueue.clear();
        downQueue.clear();

        mode = ElevatorMode.EMERGENCY;
        goToFloor(targetFloor);

        mode = ElevatorMode.NORMAL;
    }

    public void move() {
        if (mode == ElevatorMode.EMERGENCY) return;

        if (!upQueue.isEmpty()) {
            direction = Direction.UP;
            processUpRequests();
        } else if (!downQueue.isEmpty()) {
            direction = Direction.DOWN;
            processDownRequests();
        } else {
            direction = Direction.IDLE;
            state = ElevatorState.STOPPED;
        }
    }

    private void processUpRequests() {
        while (!upQueue.isEmpty()) {
            goToFloor(upQueue.poll());
        }
    }

    private void processDownRequests() {
        while (!downQueue.isEmpty()) {
            goToFloor(downQueue.poll());
        }
    }

    private void goToFloor(int floor) {
        state = ElevatorState.MOVING;
        System.out.println("Elevator " + id +
                " moving from " + currentFloor +
                " to " + floor);
        currentFloor = floor;
        state = ElevatorState.STOPPED;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}

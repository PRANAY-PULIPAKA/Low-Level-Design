package InterviewProblems.Elevator;

import java.util.PriorityQueue;

public class Elevator {

    private int id;
    private int currentFloor;

    private Direction direction;

    private ElevatorState state;

    // MinHeap for UP, MaxHeap for DOWN
    private PriorityQueue<Integer> upQueue = new PriorityQueue<>();

    private PriorityQueue<Integer> downQueue = new PriorityQueue<>((a,b) -> b - a);

    public Elevator(int id){
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.STOPPED;
    }

    public void  addRequest(int floor){
       if(floor > currentFloor){
           upQueue.offer(floor);
       } else {
           downQueue.offer(floor);
       }
    }


    public void move(){
        if(!upQueue.isEmpty()){
            direction = Direction.UP;
            processUpRequests();
        } else if (!downQueue.isEmpty()) {
            direction = Direction.DOWN;
            processDownRequests();
        } else{
            direction = Direction.IDLE;
            state = ElevatorState.STOPPED;
        }
    }

    private void processUpRequests(){
        while(!upQueue.isEmpty()){
            int nextFloor = upQueue.poll();
            goToFloor(nextFloor);
        }
    }

    private void processDownRequests(){
        while(!downQueue.isEmpty()){
            int nextFloor = downQueue.poll();
            goToFloor(nextFloor);
        }
    }

    private void goToFloor(int floor){
        state = ElevatorState.MOVING;
        System.out.println("Elevator " + id + " moving from " + currentFloor +" to " + floor);
        currentFloor = floor;
        state = ElevatorState.STOPPED;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public Direction getDirection(){
        return direction;
    }

}

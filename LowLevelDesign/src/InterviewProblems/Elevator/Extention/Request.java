package InterviewProblems.Elevator.Extention;

import InterviewProblems.Elevator.Direction;


//changes in actual Request class
public class Request {
    private int floor;
    private Direction direction;
    private RequestType type;

    public Request(int floor, Direction direction, RequestType type) {
        this.floor = floor;
        this.direction = direction;
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public RequestType getType() {
        return type;
    }
}

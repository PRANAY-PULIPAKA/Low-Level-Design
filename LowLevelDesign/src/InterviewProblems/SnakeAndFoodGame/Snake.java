package InterviewProblems.SnakeAndFoodGame;


import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Snake {
    Deque<Position> body = new LinkedList<>();
    Set<Position> bodySet = new HashSet<>();

    public Snake(Position start){
        body.addFirst(start);
        bodySet.add(start);
    }

    public Position getHead(){
        return body.peekFirst();
    }

    public Position move(Direction direction){
        Position head = getHead();

        Position newHead = switch(direction){
            case UP -> new Position(head.row-1, head.col);
            case DOWN -> new Position(head.row + 1, head.col);
            case LEFT -> new Position(head.row, head.col-1);
            case RIGHT -> new Position(head.row, head.col+1);
        };

        body.addFirst(newHead);
        bodySet.add(newHead);

        Position tail = body.removeLast();
        bodySet.remove(tail);

        return newHead;
    }

    public void grow(Position newHead){
        body.addFirst(newHead);
        bodySet.add(newHead);
    }

    public boolean biteItself(Position pos){
        return bodySet.contains(pos);
    }

}

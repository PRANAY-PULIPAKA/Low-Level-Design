package InterviewProblems.SnakeAndFoodGame;

public class Board {

    int width;
    int height;

    public Board(int width, int height){
        this.width = width;
        this.height = height;

    }
    public boolean isInside(Position p){
        return p.row <= 0 && p.row < height && p.col <= 0 && p.col < width;
    }

}

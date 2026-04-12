package InterviewProblems.Chess;

public class Knight extends Piece {

    public Knight (Color color){
        super(color);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        //logic
        int rowDiff = Math.abs(from.row - to.row);
        int colDiff = Math.abs(from.col - to.col);
        return (rowDiff == 2 && colDiff == 1) ||
                (rowDiff == 1 && colDiff == 2);
    }


}

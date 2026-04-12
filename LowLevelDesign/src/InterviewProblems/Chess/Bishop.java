package InterviewProblems.Chess;

public class Bishop extends Piece{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        return Math.abs(from.row - to.row) ==
                Math.abs(from.col - to.col);
    }

}

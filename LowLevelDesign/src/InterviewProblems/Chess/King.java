package InterviewProblems.Chess;

public class King extends Piece{
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        return Math.abs(from.row - to.row) <= 1 &&
                Math.abs(from.col - to.col) <= 1;
    }
}

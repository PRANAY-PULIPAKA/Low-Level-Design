package InterviewProblems.Chess;

public class Queen extends Piece{
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        return from.row == to.row ||
                from.col == to.col ||
                Math.abs(from.row - to.row) ==
                        Math.abs(from.col - to.col);
    }
}

package InterviewProblems.Chess;

public class Rook extends Piece{

    public Rook(Color color){
        super(color);
    }
    @Override
    public boolean canMove(Board board, Position from, Position to) {
        return from.col == to.col || from.row == to.row;
    }
}

package InterviewProblems.Chess;

public class Pawn extends Piece{
    public Pawn(Color color){
        super(color);
    }
    @Override
    public boolean canMove(Board board, Position from, Position to) {

        int direction = (color == Color.WHITE) ? -1 : 1;

        if(from.col == to.col && to.row == from.row + direction  && board.getPiece(to) == null){
            return true;
        }
        return false;
    }
}

package InterviewProblems.TicTacToe2;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move lastMove);
}

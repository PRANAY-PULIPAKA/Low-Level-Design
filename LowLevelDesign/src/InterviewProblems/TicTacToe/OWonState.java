package InterviewProblems.TicTacToe;

public class OWonState implements  GameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        // Game Over, no next state
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}

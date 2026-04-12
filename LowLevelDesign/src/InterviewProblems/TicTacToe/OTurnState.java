package InterviewProblems.TicTacToe;

public class OTurnState implements GameState{


    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if(hasWon){
            context.setState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        }

        context.setState(new XTurnState());
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}

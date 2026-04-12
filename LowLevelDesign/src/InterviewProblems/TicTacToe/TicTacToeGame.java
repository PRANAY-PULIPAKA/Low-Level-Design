package InterviewProblems.TicTacToe;

public class TicTacToeGame implements BoardGames{

    private Board board;
    private Player playerX;

    private Player playerO;

    private Player currentPlayer;

    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy xStrategy, PlayerStrategy oStrategy, int rows, int columns){
      board = new Board(rows, columns);
      playerX = new Player(Symbol.X, xStrategy);
      playerO = new Player(Symbol.O, oStrategy);
      currentPlayer = playerX;
      gameContext = new GameContext();
    }

    @Override
    public void play() {

        do {
            board.printBoard();
            Position move = currentPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());

            board.checkGameState(gameContext);
            switchPlayer();
        } while(!gameContext.isGameOver());
        announceResult();
    }

    private void switchPlayer(){
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    private void announceResult(){
        GameState state =  gameContext.getCurrentState();

        if(state instanceof XWonState){
            System.out.println("Player X wins!");
        } else if(state instanceof OWonState){
            System.out.println("Player O Wins!");
        } else{
            System.out.println("It's a draw!");
        }
    }
}

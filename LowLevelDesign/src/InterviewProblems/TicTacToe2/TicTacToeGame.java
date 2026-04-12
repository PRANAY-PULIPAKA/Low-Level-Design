package InterviewProblems.TicTacToe2;

import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    private Board board;
    private List<Player> players;

    private int currentPLayerIndex;

    private int moves;

    private WinningStrategy winningStrategy;
    private GameStatus gameStatus;


    public TicTacToeGame(int size, List<Player> players){
        this.board = new Board(size);
        this.players = players;
        this.winningStrategy = new DefaultWinningStrategy();
        this.currentPLayerIndex = 0;
        this.moves = 0;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void start(){

        Scanner sc = new Scanner(System.in);

        while (gameStatus == GameStatus.IN_PROGRESS){

            Player currentPlayer = players.get(currentPLayerIndex);
            board.display();

            System.out.println(currentPlayer.getName() + "turn:");
            int row = sc.nextInt();
            int col = sc.nextInt();

            Position pos = new Position(row, col);
            boolean placed = board.placeSymbol(pos, currentPlayer.getSymbol());


            if (!placed) {
                System.out.println("Invalid move, try again");
                continue;
            }

            moves++;

            Move move = new Move(currentPlayer, pos);

            if(winningStrategy.checkWinner(board, move)){
                board.display();
                System.out.println(currentPlayer.getName() + "WON!");
                gameStatus = GameStatus.WON;
                return;
            }

            if(moves == board.getSize() * board.getSize()){
                board.display();
                System.out.println("Game Drawn!");
                gameStatus = GameStatus.DRAW;
                return;
            }

            currentPLayerIndex = (currentPLayerIndex + 1)%  players.size();
        }
    }
}

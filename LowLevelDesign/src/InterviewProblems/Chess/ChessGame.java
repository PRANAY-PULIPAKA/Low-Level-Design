package InterviewProblems.Chess;


import java.util.Scanner;

public class ChessGame {

    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;

    public ChessGame() {
        board = new Board();
    }

    public void setPlayers(String white, String black){
        whitePlayer = new Player(white, Color.WHITE);
        blackPlayer = new Player(black, Color.BLACK);
        currentPlayer = whitePlayer;
    }

    public void  start(){

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(currentPlayer.getName() + "'s turn");

            int fr = sc.nextInt();
            int fc = sc.nextInt();
            int tr = sc.nextInt();
            int tc = sc.nextInt();

            Move move = new Move(
                    new Position(fr, fc),
                    new Position(tr, tc),
                    currentPlayer
            );

            try {
                board.movePiece(move);
                switchPlayer();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void switchPlayer() {
        currentPlayer =
                (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }


}

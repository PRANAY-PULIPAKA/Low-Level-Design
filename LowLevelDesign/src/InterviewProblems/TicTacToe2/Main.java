package InterviewProblems.TicTacToe2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            Player player1 = new Player("PlayerX", Symbol.X);
            Player player2 = new Player("PlayerO", Symbol.O);
            List<Player> players = Arrays.asList(player1, player2);
            TicTacToeGame game = new TicTacToeGame(3,players);
            game.start();

    }

}

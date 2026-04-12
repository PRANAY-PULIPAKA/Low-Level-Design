package InterviewProblems.TicTacToe2;

import InterviewProblems.TicTacToe.GameState;

public class DefaultWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getPosition().row;
        int col = move.getPosition().col;
        Symbol symbol = move.getPlayer().getSymbol();
        int size = board.getSize();
        Symbol [][] grid = board.getGrid();

        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diaMatch = true;
        boolean antiDiaMatch = true;

        for(int i = 0; i< size ; i++){
            if(grid[row][i] != symbol) rowMatch = false;
            if(grid[i][col] != symbol)  colMatch = false;
            if(grid[i][i] != symbol)  diaMatch = false;
            if(grid[i][size - i - 1] != symbol)  antiDiaMatch = false;
        }

        return rowMatch || colMatch || diaMatch || antiDiaMatch;
    }
}

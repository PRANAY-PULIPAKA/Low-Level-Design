package InterviewProblems.TicTacToe2;

public class Board {

    private int size;

    private Symbol [][] grid;

    public Board(int size){
        this.size = size;
        grid = new Symbol[size][size];


        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean placeSymbol(Position pos, Symbol symbol){
        if(grid[pos.row][pos.col] != Symbol.EMPTY){
            return false;
        }

        grid[pos.row][pos.col] = symbol;
        return true;
    }

    public Symbol [][] getGrid(){
        return grid;
    }

    public int getSize(){
        return size;
    }

    public void display(){
        for(Symbol [] row : grid){
            for(Symbol col: row){
                System.out.println(col + " ");
            }

            System.out.println();
        }
    }

}

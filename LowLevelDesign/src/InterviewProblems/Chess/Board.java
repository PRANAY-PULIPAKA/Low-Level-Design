package InterviewProblems.Chess;

public class Board {

    private Piece[][] board = new Piece[8][8];

    public Board() {
        initialize();
    }

    private void initialize() {

        for (int i = 0; i < 8; i++) {

            board[1][i] = new Pawn(Color.BLACK);
            board[6][i] = new Pawn(Color.WHITE);

        }

        //Rooks
        board[0][0] = new Rook(Color.BLACK);
        board[0][7] = new Rook(Color.BLACK);
        board[7][0] = new Rook(Color.WHITE);
        board[7][7] = new Rook(Color.WHITE);


        // Knights
        board[0][1] = new Knight(Color.BLACK);
        board[0][6] = new Knight(Color.BLACK);
        board[7][1] = new Knight(Color.WHITE);
        board[7][6] = new Knight(Color.WHITE);

        // Bishops
        board[0][2] = new Bishop(Color.BLACK);
        board[0][5] = new Bishop(Color.BLACK);
        board[7][2] = new Bishop(Color.WHITE);
        board[7][5] = new Bishop(Color.WHITE);

        // Queens
        board[0][3] = new Queen(Color.BLACK);
        board[7][3] = new Queen(Color.WHITE);

        // Kings
        board[0][4] = new King(Color.BLACK);
        board[7][4] = new King(Color.WHITE);
    }

    public Piece getPiece(Position pos) {
            return board[pos.row][pos.col];
    }

    public void movePiece(Move move){

        Position from = move.getFrom();
        Position to = move.getTo();

        Piece piece = getPiece(from);

        if (piece == null) {
            throw new RuntimeException("No piece at source");
        }

        if (piece.getColor() != move.getPlayer().getColor()) {
            throw new RuntimeException("Wrong player's piece");
        }

        if (!piece.canMove(this, from, to)) {
            throw new RuntimeException("Invalid move");
        }

        board[to.row][to.col] = piece;
        board[from.row][from.col] = null;

    }

}


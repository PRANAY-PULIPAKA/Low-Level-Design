package InterviewProblems.TicTacToe2;

public class Move {

    private Player player;
    private Position position;

    public Move(Player player, Position position){
        this.player = player;
        this.position = position;
    }

    public Player getPlayer(){
        return player;
    }

    public Position getPosition(){
        return position;
    }
}

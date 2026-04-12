package InterviewProblems.Chess;


public class Move {

    private Position from;
    private Position to;

    private Player player;

    public Move(Position from, Position to, Player player){
        this.from = from;
        this.to = to;
        this.player = player;
    }

    public Position getFrom(){
        return from;
    }

    public Position getTo(){
        return to;
    }

    public Player getPlayer(){
        return player;
    }
}

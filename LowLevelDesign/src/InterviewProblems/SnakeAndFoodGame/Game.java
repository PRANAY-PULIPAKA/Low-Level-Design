package InterviewProblems.SnakeAndFoodGame;

import java.util.Random;

public class Game {

    Board board;
    Snake snake;

    Food food;

    GameStatus status = GameStatus.RUNNING;

    Random random = new Random();

    public Game(int width, int height){
        board = new Board(width, height);
        Snake snake = new Snake( new Position(0,0));
        generateFood();
    }

    public void move(Direction direction){

        if(status == GameStatus.GAME_OVER) return;

        Position newHead = snake.move(direction);

        if(!board.isInside(newHead) || snake.biteItself(newHead)){
            status = GameStatus.GAME_OVER;
            System.out.println("Game Over!");
            return;
        }

        if(newHead.equals(food.getPosition())){
            snake.grow(newHead);
            generateFood();
        }

    }

    private void generateFood(){
        food = new Food( new Position(random.nextInt(board.height), random.nextInt(board.width)));
    }
}

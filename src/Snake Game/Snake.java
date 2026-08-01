package SnakeGame;

import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    public Deque<Position> snake = new ArrayDeque<>();

    public Snake() {
        snake.addFirst(new Position(0, 0));
    }
    
    //move normally
    public void move(Position newHead) {
        snake.addFirst(newHead);
        snake.pollLast();
    }

    //eat fruit +1
    public void grow() {
        snake.addLast(snake.peekLast());
    }

    //hit bomb -1 // decrease size 
    public void shrink() {
        snake.pollLast();
    }
}
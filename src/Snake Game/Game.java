package SnakeGame;

import java.util.Scanner;

public class Game {

    public Garden garden;
    public Snake snake;
    public boolean gameOver;

    public Game() {
        garden = new Garden();
        snake = new Snake();
        gameOver = false;
        
        //Add fruits
        garden.addFruit(new Position(2, 2));
        garden.addFruit(new Position(1, 1));
        garden.addFruit(new Position(2, 3));
        garden.addFruit(new Position(4, 3));
        garden.addFruit(new Position(3, 2));

        // Add bombs
        garden.addBomb(new Position(3, 1));
        garden.addBomb(new Position(2, 4));
        garden.addBomb(new Position(2, 5));
        garden.addBomb(new Position(0, 2));
        garden.addBomb(new Position(3, 4)); 
    }
    
    //start game 
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            garden.display(snake);
            System.out.println("1 up, 2 down, 3 left, 4 right");
            System.out.print("Enter direction: ");
            int direction = scanner.nextInt();
            move(direction);
        }
        System.out.println("Game Over!");
        scanner.close();
    }
    
    //snake moving in the garden 
    public void move(int direction) {
        Position currentHead = snake.snake.peekFirst();
        int row = currentHead.row;
        int col = currentHead.col;
        
        //calculate new position
        switch (direction) {
            case 1:
                row--;
                break;

            case 2:
                row++;
                break;

            case 3:
                col--;
                break;

            case 4:
                col++;
                break;

            default:
                System.out.println("Invalid direction!");
                return;
        }
        
        //hit wall
        Position newHead = new Position(row, col);
        if (!garden.isInside(newHead)) {
            gameOver = true;
            return;
        }
        
        //eat fruit > grow
        if (garden.hasFruit(newHead)) {
            snake.grow();
            snake.move(newHead);
            garden.clear(newHead);
            
        //eat bomb > shrink
        } else if (garden.hasBomb(newHead)) {
            snake.move(newHead);
            snake.shrink();
            garden.clear(newHead);
            
         // Check game over
            if (snake.snake.isEmpty()) {
                gameOver = true;
            }
        } else {
            snake.move(newHead);
        }
    }
}
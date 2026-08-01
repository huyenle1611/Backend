package SnakeGame;

public class Garden {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    public static final int FRUIT = 1;
    public static final int BOMB = -1;
    public static final int SNAKE = 2;

    // Garden
    public int[][] garden = new int[HEIGHT][WIDTH];

    public void addFruit(Position p) {
        garden[p.row][p.col] = FRUIT;
    }

    public void addBomb(Position p) {
        garden[p.row][p.col] = BOMB;
    }

    // Check whether position is inside garden
    public boolean isInside(Position p) {
        if (p.row >= 0 && p.row < HEIGHT && p.col >= 0 && p.col < WIDTH) {
            return true;
        }
        return false;
    }

    // Check fruit
    public boolean hasFruit(Position p) {
        return garden[p.row][p.col] == FRUIT;
    }

    // Check bomb
    public boolean hasBomb(Position p) {
        return garden[p.row][p.col] == BOMB;
    }

    // Remove fruit / bomb after snake eats 
    public void clear(Position p) {
        garden[p.row][p.col] = 0;
    }

 // Display garden
    public void display(Snake snake) {

        int[][] map = new int[HEIGHT][WIDTH];

        // Copy garden to map
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                map[row][col] = garden[row][col];
            }
        }
        // Put snake on map
        for (Position p : snake.snake) {
            int row = p.row;
            int col = p.col;
            map[row][col] = SNAKE;
        }

        // Print map
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                int value = map[row][col];
                if (value == SNAKE) {
                    System.out.print(" S ");
                }
                else if (value == FRUIT) {
                    System.out.print("+1 ");
                }
                else if (value == BOMB) {
                    System.out.print("-1 ");
                }
                else {
                    System.out.print(" . ");
                }
            }
            // Go to next row
            System.out.println();
        }
    }
}

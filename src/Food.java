import java.awt.*;

public class Food {
    private int x;
    private int y;

    public Food(Snake snake) {
        this.random_spawn(snake);
    }

    public void random_spawn(Snake snake) {
        boolean onSnake = true;

        while (onSnake) {
            onSnake = false;
            x = (int) (Math.random() * Game.width - 1);
            y = (int) (Math.random() * Game.height - 1);

            for (Rectangle rectangle : snake.getBody()) {
                if (rectangle.x == x && rectangle.y == y) {
                    onSnake = true;
                }

            }
        }
    }//end random_spawn

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {
    private Snake snake;
    private Food food;

    private JFrame window;
    private Graphics graphics;

    protected static final int width = 30;
    protected static final int height = 30;
    protected static final int dimension = 20;

    public Game() {
        window = new JFrame("Snake");

        snake = new Snake();
        food = new Food(snake);
        graphics = new Graphics(this);
        window.add(graphics);

        window.setSize(width * dimension + 2, height * dimension + dimension + 4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end Game constructor

    public void start() {
        graphics.state = "RUNNING";
    }

    public void update() {
        if (graphics.state == "RUNNING") {
            if (food_collision()) {
                snake.grow();
                food.random_spawn(snake);
            } else if (wall_collision() || self_collision()) {
                graphics.state = "END";
            } else {
                snake.move();
            }
        }
    }

    public boolean wall_collision() {
        boolean res = false;
        if (snake.getX() < 0 || snake.getX() >= width * dimension || snake.getY() < 0 || snake.getY() >= height * dimension) {
            res = true;
        }
        return res;
    }

    public boolean food_collision() {
        boolean res = false;
        if (snake.getX() == food.getX() * dimension && snake.getY() == food.getY() * dimension) {
            res = true;
        }
        return res;
    }

    public boolean self_collision() {
        boolean res = false;
        for (int i = 0; i < snake.getBody().size(); i++) {
            if (snake.getX() == snake.getBody().get(i).x && snake.getY() == snake.getBody().get(i).y) {
                res = true;
            }
        }
        return res;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (graphics.state == "RUNNING") {
            if (keyCode == KeyEvent.VK_W) {
                snake.up();
            } else if (keyCode == KeyEvent.VK_S) {
                snake.down();
            } else if (keyCode == KeyEvent.VK_A) {
                snake.left();
            } else if (keyCode == KeyEvent.VK_D) {
                snake.right();
            }
        } else {
            this.start();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}

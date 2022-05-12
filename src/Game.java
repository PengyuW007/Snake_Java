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
        window.setSize(width * dimension, height * dimension);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            snake.up();
        } else if (keyCode == KeyEvent.VK_S) {
            snake.down();
        } else if (keyCode == KeyEvent.VK_A) {
            snake.left();
        } else if (keyCode == KeyEvent.VK_D) {
            snake.right();
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

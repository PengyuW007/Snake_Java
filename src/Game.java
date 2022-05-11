import javax.swing.*;

public class Game {
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
}

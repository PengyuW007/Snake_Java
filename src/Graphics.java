import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends JPanel implements ActionListener {
    private Timer t = new Timer(100, this);
    protected String state;

    private Snake snake;
    private Food food;
    private Game game;

    public Graphics(Game g) {
        t.start();
        state = "START";
        game = g;
        snake = g.getSnake();
        food = g.getFood();

        // add a keyListener
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, Game.width * Game.dimension+5, Game.height * Game.dimension+5);

        if (state == "START") {
            g2d.setColor(Color.white);
            g2d.drawString("Press any key", Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
        }else if(state=="RUNNING"){
            g2d.setColor(Color.RED);
            g2d.fillRect(food.getX() * Game.dimension, food.getY() * Game.dimension, Game.dimension, Game.dimension);

            g2d.setColor(Color.GREEN);

            for (Rectangle rectangle : snake.getBody()) {
                g2d.fill(rectangle);
            }
        }else{
            g2d.setColor(Color.white);
            g2d.drawString("Your score: "+(snake.getBody().size()-3), Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();
    }
}

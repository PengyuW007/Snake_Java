import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> body;
    private int w = Game.width;
    private int h = Game.height;
    private int d = Game.dimension;

    private String move;

    public Snake() {
        body = new ArrayList<>();
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation(Game.width / 2 * Game.dimension, Game.height / 2 * Game.dimension);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2 - 1) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2 - 2) * d);
        body.add(temp);

        move = "NOTHING";
    }//end Snake constructor

    public void move() {
        if (move != "NOTHING") {
            Rectangle first = body.get(0);
            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

            if (move == "UP") {
                temp.setLocation(first.x, first.y - Game.dimension);
            } else if (move == "DOWN") {
                temp.setLocation(first.x, first.y + Game.dimension);
            } else if (move == "LEFT") {
                temp.setLocation(first.x - Game.dimension, first.y);
            } else if (move == "RIGHT") {
                temp.setLocation(first.x + Game.dimension, first.y);
            }

            body.add(0,temp);
            body.remove(body.size()-1);
        }
    }//end move

    public void grow(){
        Rectangle first = body.get(0);
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

        if (move == "UP") {
            temp.setLocation(first.x, first.y - Game.dimension);
        } else if (move == "DOWN") {
            temp.setLocation(first.x, first.y + Game.dimension);
        } else if (move == "LEFT") {
            temp.setLocation(first.x - Game.dimension, first.y);
        } else if (move == "RIGHT") {
            temp.setLocation(first.x + Game.dimension, first.y);
        }

        body.add(0,temp);
        body.remove(body.size()-1);
    }//end grow

    public void up() {
        move = "UP";
    }

    public void down() {
        move = "DOWN";
    }

    public void left() {
        move = "LEFT";
    }

    public void right() {
        move = "RIGHT";
    }

    /*Helper methods*/
    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    private final int x;
    private int y;
    private final int width = 10, height = 100;
    private int yVelocity = 0;
    private final double speed = 6.5;
    private final int upKey, downKey;

    public Paddle(int x, int y, int upKey, int downKey) {
        this.x = x;
        this.y = y;
        this.upKey = upKey;
        this.downKey = downKey;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public void move(int panelHeight) {
        y += yVelocity;
        if (y < 0) y = 0;
        if (y > panelHeight - height) y = panelHeight - height;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == upKey) yVelocity = -speed;
        if (e.getKeyCode() == downKey) yVelocity = speed;
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == upKey || e.getKeyCode() == downKey) yVelocity = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
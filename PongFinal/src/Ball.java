import java.awt.*;

public class Ball {
    private int x, y;
    private final int size = 20;
    private int xVelocity = 4, yVelocity = 4;
    private final Paddle paddle1, paddle2;
    private final ScoreBoard scoreBoard;
    private final int panelWidth, panelHeight;

    public Ball(int x, int y, Paddle paddle1, Paddle paddle2, ScoreBoard scoreBoard, int panelWidth, int panelHeight) {
        this.x = x;
        this.y = y;
        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
        this.scoreBoard = scoreBoard;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, size, size);
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;

        if (y <= 0 || y >= panelHeight - size) yVelocity = -yVelocity;

        if (getBounds().intersects(paddle1.getBounds()) || getBounds().intersects(paddle2.getBounds()))
            xVelocity = -xVelocity;

        if (x <= 0) {
            scoreBoard.incrementPlayer2();
            reset();
        }

        if (x >= panelWidth - size) {
            scoreBoard.incrementPlayer1();
            reset();
        }
    }

    private void reset() {
        x = panelWidth / 2 - size / 2;
        y = panelHeight / 2 - size / 2;
        xVelocity = -xVelocity;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private static final int WIDTH = 800, HEIGHT = 600;
    private final Timer timer;
    private final Paddle paddle1, paddle2;
    private final Ball ball;
    private final ScoreBoard scoreBoard;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        scoreBoard = new ScoreBoard();
        paddle1 = new Paddle(10, HEIGHT / 2 - 50, KeyEvent.VK_W, KeyEvent.VK_S);
        paddle2 = new Paddle(WIDTH - 20, HEIGHT / 2 - 50, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        ball = new Ball(WIDTH / 2 - 10, HEIGHT / 2 - 10, paddle1, paddle2, scoreBoard, WIDTH, HEIGHT);

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paddle1.move(HEIGHT);
        paddle2.move(HEIGHT);
        ball.move();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        scoreBoard.draw(g, WIDTH);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        paddle1.keyPressed(e);
        paddle2.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        paddle1.keyReleased(e);
        paddle2.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
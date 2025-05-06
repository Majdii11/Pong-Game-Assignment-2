import static utils.Constants.*;

public class Ball extends Sprite {
    private double vx;
    private double vy;

    public Ball() {
        super(BALL_IMAGE_PATH, 0, 0, BALL_WIDTH, BALL_HEIGHT);
        reset();
    }

    public void reset() {
        pos.x = BOARD_WIDTH / 2 - BALL_WIDTH / 2;
        pos.y = BOARD_HEIGHT / 2 - BALL_HEIGHT / 2;
        // Move the ball to the center of the screen
        // Look at how this is done to Wall in Board.java for inspiration

        // Reset the ball's velocity
        // It should randomly move up left, up right, down left, or down right
        // At first, make it move in one direction and add randomness later
        vx = BALL_SPEED;
        vy = BALL_SPEED;
    }

    @Override
    public void tick() {
        pos.translate((int) vx, (int) vy);


        pos.x = Math.clamp(pos.x, 0, BOARD_WIDTH - BALL_WIDTH);
        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - BALL_HEIGHT);
        // Move the ball based on vx and vy
        // Look at Player.java for inspiration
    }
}

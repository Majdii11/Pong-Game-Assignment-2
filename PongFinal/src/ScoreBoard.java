import java.awt.*;

public class ScoreBoard {
    private int player1Score = 0;
    private int player2Score = 0;

    public void incrementPlayer1() {
        player1Score++;
    }

    public void incrementPlayer2() {
        player2Score++;
    }

    public void draw(Graphics g, int panelWidth) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 36));
        g.drawString(String.valueOf(player1Score), panelWidth / 4, 50);
        g.drawString(String.valueOf(player2Score), panelWidth * 3 / 4, 50);
    }
}
import java.awt.image.*;
import java.text.DecimalFormat;
import java.awt.*;

public class UI {

    GamePanel gp;
    Font arial_30;
    Font arial_60;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    boolean gameFinished = false;
    double playTime;
    DecimalFormat df = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_30 = new Font("Arial", Font.PLAIN, 30);
        arial_60 = new Font("Arial", Font.BOLD, 60);
        key key = new key();
        keyImage = key.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        if (gameFinished == true) {

            g2.setFont(arial_30);
            g2.setColor(Color.WHITE);

            String text;
            int textLength;
            int x;
            int y;

            text = "Treasure Acquired. You have completed this level !!!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 2);

            g2.drawString(text, x, y);

            text = "Your time is : " + df.format(playTime);
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 3);

            g2.drawString(text, x, y);

            g2.setFont(arial_60);
            g2.setColor(Color.YELLOW);

            text = "CONGRATULATIONS !!!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize * 2);

            g2.drawString(text, x, y);

            gp.gameThread = null;
        } else {

            // g2.setFont(new Font("Arial",Font.PLAIN, 40)); // Dont use with gameloop
            // because it takes time and will slow down game
            g2.setFont(arial_30);
            g2.setColor(Color.WHITE);
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 70, 70);

            // Time
            playTime += (double) 1 / 60;
            g2.drawString("Time:" + df.format(playTime), gp.tileSize * 11, 70);

            // message

            if (messageOn == true) {
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

                messageCounter++;

                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }

    }

}

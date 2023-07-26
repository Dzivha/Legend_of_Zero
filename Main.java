import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Legend of Zero");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); // Causes this window to be sized to fit the preferred size and layout of its
                       // subcomponents (=GamePanel)

        window.setLocationRelativeTo(null); // Window will be displayed at the centre of the screen
        window.setVisible(true);

        gamePanel.setupGame();

        gamePanel.startGameThread();
    }
}
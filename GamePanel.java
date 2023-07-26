import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    // Screen settings
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //World settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    //System    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    sounds music = new sounds();
    sounds SE = new sounds();
    public UI ui = new UI(this);
    Thread gameThread;
    collisionCheck cChecker = new collisionCheck(this);
    public ObjectManager oManager = new ObjectManager(this);

    // Entity and object
    Player player = new Player(this, keyH);
    public  SuperObject obj[] = new SuperObject[10];

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // if set to true, all the drawing from this component will be done in an
                                      // offscreen painting buffer
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        oManager.setObject();
        playMusic(0);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta =0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread!=null){

            currentTime=System.nanoTime();

            delta+=(currentTime-lastTime)/drawInterval;
            lastTime = currentTime;

            if(delta>=1){       
            update();
            repaint();
            delta--;
            }

        }
    }


    /* 
         @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // draw screen 60 times per second
        double nextDrawTime = System.nanoTime()+drawInterval;
        while (gameThread != null) {

            update();
            repaint();

            double remainingTime = nextDrawTime - System.nanoTime();
            try {
                remainingTime = remainingTime/1000000;

                if(remainingTime<0){
                    remainingTime=0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime+=drawInterval;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    */

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //Tile
        tileM.draw(g2);

        //Object
        for(int i=0; i<obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }

        // Player
        player.draw(g2);

        //UI
        ui.draw(g2);
        
        g2.dispose();

    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }

    public void playSE(int i){
        SE.setFile(i);
        SE.play();
    }
}

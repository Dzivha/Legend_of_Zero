import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class sounds {

    Clip clip;
    URL soundURL[] = new URL[30];
    
    public sounds() {

        soundURL[0] = getClass().getResource("/res/Sounds/BlueBoyAdventure.wav");
        soundURL[1] = getClass().getResource("/res/Sounds/coin.wav");
        soundURL[2] = getClass().getResource("/res/Sounds/powerup.wav");
        soundURL[3] = getClass().getResource("/res/Sounds/unlock.wav");
        soundURL[4] = getClass().getResource("/res/Sounds/fanfare.wav");
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        }catch(Exception e){

        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}

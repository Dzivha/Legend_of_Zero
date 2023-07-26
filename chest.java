import java.io.IOException;

import javax.imageio.ImageIO;

public class chest extends SuperObject {
    public chest(){
        name ="Chest";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/chest.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


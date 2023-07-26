import java.io.IOException;

import javax.imageio.ImageIO;

public class door extends SuperObject {
    public door(){
        name ="Door";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/door.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}

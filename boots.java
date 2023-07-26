import java.io.IOException;

import javax.imageio.ImageIO;

public class boots extends SuperObject {
    public boots(){
        name ="Boots";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/boots.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

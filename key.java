import java.io.IOException;

import javax.imageio.ImageIO;

public class key extends SuperObject {
    
    public key(){
        name ="Key";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/key.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

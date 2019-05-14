import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    public Vecto2D position;
    public BufferedImage image;

    public Background(){
        this.position = new Vecto2D();
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
    }
    public void render (Graphics g){
        g.drawImage(this.image,(int) position.x,(int) position.y,null);
    }

    public void run(){
        this.position.y +=4;
        if(this.position.y>0){
            this.position.y = 600 -3109;
        }
    }
}

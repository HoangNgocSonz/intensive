package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet {

    public Vecto2D position;
    public BufferedImage image;

    public PlayerBullet(){
        this.position=new Vecto2D();
        this.image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
    }

    public void render (Graphics g){
        g.drawImage(this.image, (int) this.position.x,(int) this.position.y,null);
    }
    public void run(){
        this.position.y -= 6;
    }
}


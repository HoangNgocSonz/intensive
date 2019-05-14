package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {

    public Vecto2D position;
    public BufferedImage image;

    public static ArrayList<PlayerBullet> playerBullets;

    public Player(){
        this.position = new Vecto2D();
        this.image = SpriteUtils.loadImage("assets/images/players/straight/1.png");
        playerBullets = new ArrayList<>();
    }

    public void render(Graphics g){
        g.drawImage(this.image,(int)position.x, (int) position.y, null);
        for(int i= 0; i<playerBullets.size();i++){
            PlayerBullet bullet = playerBullets.get(i);
            bullet.render(g);
        }
    }

    public void run() {
        this.shoot();
        if (KeyEventPress.isUpPress) {
            position.y -= 4;
        }
        if (KeyEventPress.isDownPress) {
            position.y += 4;
        }
        if (KeyEventPress.isLeftPress) {
            position.x -= 4;
        }
        if (KeyEventPress.isRightPress) {
            position.x += 4;
        }
        position.x = Mathx.clamp(position.x, 0, 384 - image.getWidth());
        position.y = Mathx.clamp(position.y, 0, 600 - image.getHeight());

    }
    int count =0;
    private void shoot(){
        count ++;
        if(KeyEventPress.isFirePress &&count>8){
            PlayerBullet bullet = new PlayerBullet();
            Player.playerBullets.add(bullet);
            bullet.position.set(this.position.x +2, this.position.y);

//            game.PlayerBullet bullet2 = new game.PlayerBullet();
//            game.Player.playerBullets.add(bullet2);
//            bullet2.position.set(this.position.x+2-10,this.position.y);
//
//            game.PlayerBullet bullet3 = new game.PlayerBullet();
//            game.Player.playerBullets.add(bullet3);
//            bullet3.position.set(this.position.x+2+10,this.position.y);

            count = 0;
        }
        for(int i = 0;i<playerBullets.size();i++){
            PlayerBullet bullet = playerBullets.get(i);
            bullet.run();
        }

    }
}



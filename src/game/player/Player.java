package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Vecto2D;
import game.physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {

    public Player(){
        position.set(200,500);
        this.image = SpriteUtils.loadImage("assets/images/players/straight/1.png");
        hitBox = new BoxCollider(this,40,40);
    }
    int count = 0;
    @Override
    public void run(){
        this.move();
        this.limitPosition();
        this.shoot();
    }

    private void move() {
        if (KeyEventPress.isUpPress) {
            position.y -= 6;
        }
        if (KeyEventPress.isDownPress) {
            position.y += 6;
        }
        if (KeyEventPress.isLeftPress) {
            position.x -= 6;
        }
        if (KeyEventPress.isRightPress) {
            position.x += 6;
        }
    }

    private void limitPosition() {
        position.x = Mathx.clamp(position.x, 0, 384 - image.getWidth());
        position.y = Mathx.clamp(position.y, 0, 600 - image.getHeight());
    }

    private void shoot(){
        count ++;
        if(KeyEventPress.isFirePress &&count>8){
            //PlayerBullet bullet = new PlayerBullet();
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position.x +3, this.position.y +3);
            bullet.velocity.setAngle(Math.toRadians(-90));


            PlayerBullet bullet2 = GameObject.recycle(PlayerBullet.class);
            bullet2.position.set(this.position.x +3, this.position.y+3);
            bullet2.velocity.setAngle(Math.toRadians(-100));

            PlayerBullet bullet3 = GameObject.recycle(PlayerBullet.class);
            bullet3.position.set(this.position.x +3, this.position.y+3);
            bullet3.velocity.setAngle(Math.toRadians(-80));

            PlayerBullet bullet4 = GameObject.recycle(PlayerBullet.class);
            bullet4.position.set(this.position.x +3, this.position.y+3);
            bullet4.velocity.setAngle(Math.toRadians(-70));

            PlayerBullet bullet5 = GameObject.recycle(PlayerBullet.class);
            bullet5.position.set(this.position.x +3, this.position.y+3);
            bullet5.velocity.setAngle(Math.toRadians(-110));

            PlayerBullet bullet6 = GameObject.recycle(PlayerBullet.class);
            bullet6.position.set(this.position.x +3, this.position.y+3);
            bullet6.velocity.setAngle(Math.toRadians(-60));

            PlayerBullet bullet7 = GameObject.recycle(PlayerBullet.class);
            bullet7.position.set(this.position.x +3, this.position.y+3);
            bullet7.velocity.setAngle(Math.toRadians(-120));

            PlayerBullet bullet8 = GameObject.recycle(PlayerBullet.class);
            bullet8.position.set(this.position.x +3, this.position.y +3);
            bullet8.velocity.setAngle(Math.toRadians(-130));

            PlayerBullet bullet9 = GameObject.recycle(PlayerBullet.class);
            bullet9.position.set(this.position.x +3, this.position.y +3);
            bullet9.velocity.setAngle(Math.toRadians(-50));

            count = 0;
        }
    }
}



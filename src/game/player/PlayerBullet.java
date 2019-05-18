package game.player;

import game.GameObject;
import game.Vecto2D;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import tklibs.SpriteUtils;


public class PlayerBullet extends GameObject {
    //public int damage;
    public int damage;

    public PlayerBullet(){
        this.image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        velocity.set(0,5);
        hitBox = new BoxCollider(this,24,24);
        damage =1;
    }

    @Override
    public void run(){
        super.run();
        this.checkEnemy();
        this.deactiveIfNeeded();
    }
    private void checkEnemy(){
        Enemy enemy = GameObject.findIntersects(Enemy.class, hitBox);
        if(enemy != null){
            enemy.takeDamage(damage);
            this.deactive();
        }
    }
    public void deactiveIfNeeded(){
        if(position.y <30){
            this.deactive();
        }
    }

}


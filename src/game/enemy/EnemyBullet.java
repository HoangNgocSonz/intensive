package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {

    public EnemyBullet(){
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        velocity.set(0,5);
        hitBox = new BoxCollider(this,24,24);
    }

    @Override
    public void run(){
        super.run();
        this.deactiveIfNeeded();
    }

    public void deactiveIfNeeded(){
        if(position.y <30){
            this.deactive();
        }
    }
}

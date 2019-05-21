package game;

import game.physics.BoxCollider;
import game.renderer.Renderer;

public class ItemExtendsGameObject extends GameObject {
    public ItemExtendsGameObject(){
        //this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        renderer = new Renderer("assets/images/items/power-up-red.png");
        velocity.set(0,7);
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

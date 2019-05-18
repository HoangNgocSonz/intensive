package game.enemy;
import game.GameObject;
import game.KeyEventPress;
import game.physics.BoxCollider;
import game.player.Player;
import game.player.PlayerBullet;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public int hp;

    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/1.png");
        position.set(0,0);
        velocity.set(0,5);
        velocity.setAngle(Math.toRadians(5));
        hitBox = new BoxCollider(this,28,28);
        hp = 3;
    }

    public void takeDamage(int damage){
        hp -= damage;
        if(hp <=0){
            hp=0;
            this.deactive();
        }
    }

    @Override
    public void run() {
        super.run();
        this.checkPlayer();
        if (this.onGoingRight() && this.outOfBoundRight()) {
            this.reverseVelocity();
        }
        if (this.onGoingLeft() && this.outOfBoundLeft()) {
            this.reverseVelocity();
        }
        this.deactiveIfNeeded();

        this.shoot();
    }

    @Override
    public void reset() {
        super.reset();
        position.set(0, 0);
        velocity.set(0, 5);
        velocity.setAngle(Math.toRadians(5));
        hp = 3;
    }

    public boolean onGoingRight() {
        return velocity.x > 0;
    }

    public boolean outOfBoundRight() {
        return position.x > 350;
    }

    public void reverseVelocity() {
        velocity.x = -velocity.x;
    }

    public boolean onGoingLeft() {
        return velocity.x < 0;
    }

    public boolean outOfBoundLeft() {
        return position.x < 0;
    }

    public void deactiveIfNeeded() {
        if (position.y > 600) {
            this.deactive();
        }
    }

    private void checkPlayer(){
        Player player = GameObject.findIntersects(Player.class, hitBox);
        if(player != null){
            this.deactive();
            player.deactive();
        }
    }

    int countx = 0;
    private void shoot(){
        countx ++;
        if(countx>30){
            //PlayerBullet bullet = new PlayerBullet();
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position.x , this.position.y );
            bullet.velocity.setAngle(Math.toRadians(90));

            countx = 0;
        }
    }
}
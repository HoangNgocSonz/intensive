package game.enemy;

import game.GameObject;

public class EnemySummoner extends GameObject {
    public EnemySummoner(){

    }
    int count = 0;
    @Override
    public void run(){
        count ++;
        if(count >20){
            Enemy enemy = GameObject.recycle(Enemy.class);
            count = 0;
        }
    }
}

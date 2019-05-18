package game;

import game.enemy.Enemy;
import game.enemy.EnemySummoner;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    Player player;
    Background background;
    EnemySummoner es;
    public GamePanel(){
        background = new Background();
        player = new Player();
        //enemy = new Enemy();
        es = new EnemySummoner();

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for(int i = 0; i<GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.render(g);
            }
        }
        /////////////////////////////
        g.setColor(Color.YELLOW);
        g.fillRect(384,0,416,600);


        ////////////////////////////////
    }

    public void gameLoop(){
        long lastTime = 0;
        while(true){
            long currenTime = System.currentTimeMillis();
            if(currenTime - lastTime > 1000/60){
                this.runAll();
                this.repaint();
                lastTime = currenTime;
            }
        }
    }
    public void runAll(){
        for(int i = 0;i < GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.run();
                object.run(player);
            }
        }
//        this.player.run();
//        this.background.run();
    }
}

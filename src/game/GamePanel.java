import tklibs.Mathx;
import tklibs.SpriteUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    Player player;
    Background background;

    public GamePanel(){
        this.player = new Player();
        this.player.position.set(200,500);

        this.background = new Background();
        this.background.position.set(0,600-3109);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.background.render(g);
        this.player.render(g);
    }

    public void gameLoop(){
        long lastTime = 0;
        while (true){
            long currenTime = System.currentTimeMillis();
            if(currenTime - lastTime > 1000/60){
                this.runAll();
                this.repaint();
                lastTime = currenTime;
            }
        }
    }

    public void runAll(){
        this.player.run();
        this.background.run();
    }
}

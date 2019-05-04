import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel {
    BufferedImage playerImagae;
    BufferedImage bkImage;
//    int playerX;
//    int playerY;
    Vecto2D playerPosition; // khai báo đối tượng playerPosition

    //int bkX,bkY;
    Vecto_bk bkPosition;

    public GamePanel(){
        playerImagae = SpriteUtils.loadImage("assets/images/players/straight/1.png");
        bkImage = SpriteUtils.loadImage("assets/images/background/0.png");
        this.repaint();
//        playerX=175;
//        playerY=500;
        playerPosition = new Vecto2D(200,500);// tạo tọa độ ban đầu cho player
        //bkX=0;
        //bkY=600-bkImage.getHeight();
        bkPosition = new Vecto_bk (0,600-bkImage.getHeight());
       // bkY=600-getHeight(bkImage);
    }

    @Override
    public void paint(Graphics g) {
        //System.out.println("paint");
        super.paint(g);
        g.setColor(Color.GREEN);

        g.drawImage(bkImage,(int) bkPosition.x,(int)bkPosition.y, null);
        g.drawImage(playerImagae,(int) playerPosition.x, (int) playerPosition.y, null);// vẽ vào tọa độ đã tạo
    }
    public void gameLoop(){
        long lastTime=0;
        while (true){
            long currenTime =System.currentTimeMillis();
            if(currenTime - lastTime >1000/60){
                this.runAll();
                //System.out.println(currenTime-lastTime);
                this.repaint();
                lastTime=currenTime;
            }
        }
    }
    public void runAll(){
        //player run;
        if(KeyEventPress.isUpPress){
           // if(playerY>=0)
            playerPosition.y-=4;
        }
        if(KeyEventPress.isDownPress){
            playerPosition.y+=4;
        }
        if(KeyEventPress.isLeftPress){
            //if(playerX>=0)
            playerPosition.x-=4;
        }
        if(KeyEventPress.isRight){
            //if(playerX<=400-playerImagae.getWidth())
            playerPosition.x+=4;
        }
        playerPosition.x= Mathx.clamp(playerPosition.x,0,384-playerImagae.getWidth());
        playerPosition.y= Mathx.clamp(playerPosition.y,0,600-playerImagae.getHeight());



        //bk run
        bkPosition.y+=3;
        if(bkPosition.y>-460) bkPosition.y=600-bkImage.getHeight();

    }

}

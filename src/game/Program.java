package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Program{
    public static void main(String[] args){

        Long time = System.currentTimeMillis() /1000/60/60/24/365;
        JFrame window = new JFrame();
        GamePanel panel = new GamePanel();
        panel.setBackground(Color.YELLOW);
        panel.setPreferredSize(new Dimension(800,600));
        window.add(panel);
        window.pack();
        window.setTitle("Game Touho");

        //window.setSize(800,600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        KeyAdapter KeyHanled = new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEventPress.isFirePress = true;
                }

        }

                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_W) {
                        KeyEventPress.isUpPress = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_S) {
                        KeyEventPress.isDownPress = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_A) {
                        KeyEventPress.isLeftPress = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_D) {
                        KeyEventPress.isRightPress = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        KeyEventPress.isFirePress = false;
                    }
                }
        };

        window.addKeyListener(KeyHanled);
        window.setLocation(340,100);
        window.setVisible(true);
        panel.gameLoop();

    }



}
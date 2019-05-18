package game;
import game.physics.BoxCollider;
import game.player.Player;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E recycle (Class<E>  cls){
        E object = findInactive(cls);
        if(object != null){
            object.reset();
            return object;
        }
        try{
            object = cls.getConstructor().newInstance();
            return object;
        }catch(Exception ex){
            return null;
        }
    }

    public static <E extends GameObject> E findInactive(Class<E> cls){
        //cls : Player.class || background.class
        // E : Player || Background
        //TODO
        for(int i=0; i< objects.size();i++){
            GameObject object = objects.get(i);
            if(cls.isAssignableFrom(object.getClass())
            && !object.active){
                return (E)object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox){
        for (int i = 0; i <objects.size() ; i++) {
            GameObject object = objects.get(i);
            //1, dang active
            // 2. object ~ cls
            // 3.object.hitBox.intersects(hitBox)
            if(object.active
                    && cls.isAssignableFrom(object.getClass())
                    && object.hitBox != null
                    && object.hitBox.intersects(hitBox)){
                return (E) object;
            }
        }
        return null;
    }

//    public static  void main (String[] args){
//        Player deactivatePlayer = findInactive(Player.class);
//        PlayerBullet deactiveBullet = findInactive(PlayerBullet.class);
//    }

    public BufferedImage image;
    public Vecto2D position;
    public boolean active;
    public Vecto2D velocity;
    public BoxCollider hitBox;

    public GameObject(){
        objects.add(this);
        position = new Vecto2D();
        active = true;
        velocity = new Vecto2D();
    }

    public void render (Graphics g){
        if(image != null){
            g.drawImage(image, (int) position.x, (int) position.y,null);
        }
    }
    public void run(){
        position.add(velocity.x, velocity.y);
    }
    public void run(Player other){}
    public void deactive(){
        active = false;
    }
    public void reset(){
        active = true;
    }
}






//generic
//class Class
//class Type

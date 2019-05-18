package game.physics;

import game.Background;
import game.GameObject;
import game.Vecto2D;

public class BoxCollider {
    public int width;
    public int height;
    public Vecto2D position;

    public BoxCollider(GameObject master, int width, int height){
        this.position = master.position;
        this.width = width;
        this.height = height;
    }

    public double top(){
        return position.y;
    }
    public double bot(){
        return this.top() + this.height;
    }
    public double left(){
        return this.position.x;
    }
    public double right(){
        return  this.left() + width;
    }

    public boolean intersects(BoxCollider other){
        // box dc goi (this) co giao voi box truyen vao(other) hay ko
        return  (this.right() >=other.left()
                && other.right() >=this.left()
                && this.bot()>= other.top()
                && other.bot() >= this.top());

    }
}

public class Rectangle {
    public Vecto2D position;
    public int width;
    public int height;


    public Rectangle() {
        this(new Vecto2D(0, 0), 1, 1);
    }

    public Rectangle(double x, double y, int width, int height) {
        this(new Vecto2D(x, y), width, height);
    }

    public Rectangle(Vecto2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }
    double top()
    {
        return this.position.y;
    }

    double bottom()
    {
        return  this.top() + this.height;
    }
    double left()
    {
        return this.position.x;
    }

    double right()
    {
        return this.left() + this.width;
    }


    public boolean intersects(Rectangle other)
    {
        if( this.right() >= other.left() && other.right()>=this.left()
        && this.bottom()>= other.top() && other.bottom()>=this.top() )
            return  true;
        else return false;
    }

//    public boolean intersects(Rectangle other) {
//        Vecto2D position;
//        int width;
//        int height;
//        position= this.position;
//        width = this.width;
//        height=this.height;
//
//        Rectangle rect = new Rectangle(position,width, height);
//        if((rect.position.x+rect.width>=other.position.x)&&(other.position.x+other.width>=rect.position.x)&&
//                (rect.position.y+rect.height>=other.position.y)&&(other.position.y+other.width>=rect.position.y))
//            return true;
//        else
//            return false;
//    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(3, 3, 5, 5);
        Rectangle rect3 = new Rectangle(6, 6, 5, 5);

        System.out.println(rect1.intersects(rect2) + " - " + true);
        System.out.println(rect2.intersects(rect3) + " - " + true);
        System.out.println(rect1.intersects(rect3) + " - " + false);


        // the result must be:
        // true - true
        // true - true
        // false - false
    }
}

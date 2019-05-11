import tklibs.Mathx;

public class Vecto2D {

    public double x;
    public double y;

    public Vecto2D(){
        this(0,0) ;// this.x=0,this.y=0
    }

    public Vecto2D(double x, double y){
        this.x=x;
        this.y=y;
    }

    public void add(double x, double y){
        this.x+=x;
        this.y+=y;
    }

    public void substract(double x,double y)
    {
        this.x -=x;
        this.y -=y;
    }

    public void scale(double rate){
        this.x*=rate;
        this.y*=rate;
    }

    public void set(double x, double y){
        this.x=x;
        this.y=y;
    }

    public void set(Vecto2D other){

    }
    {
        this.x =x;
        this.y =y;
    }

    public Vecto2D clone(){
        return new Vecto2D(this.x,this.y);
    }

    public double getLength(){
        return Math.sqrt(x*x + y*y);
    }

    public void setLength(double length){
        double oldLength = this.getLength();
        if(oldLength !=0){
            this.x = this.x *length/oldLength;
            this.y = this.y *length/oldLength;
        }
    }
    public double getAngle(){
        return Math.atan(y/x);
    }

    public void setAngle(){
        double length =this.getLength();
        if(length!=0){
            this.x=length* Math.cos(this.getAngle());
            this.y=length* Math.sin(this.getAngle());
        }
    }
}

import game.Vecto2D;

import java.util.ArrayList;

import static java.lang.StrictMath.sqrt;

public class Employee {
    public static void main(String[] args){
        ArrayList<Vecto2D> vectors = new ArrayList<>();
        vectors.add(new Vecto2D(1,1));
        vectors.add(new Vecto2D(2,2));
        vectors.add(new Vecto2D(2.4,3));
        vectors.add(new Vecto2D(5,5));
        vectors.add(new Vecto2D(2,4));
        vectors.add(new Vecto2D(3,3));
        vectors.add(new Vecto2D(10,1));

        double maxTotal = 0;
        int indexMax = 0;
        for(int i =0; i < vectors.size(); i++){
            Vecto2D vector = vectors.get(i);
            //System.out.println(vector.x +" "+vector.y);
          if(vector.x+vector.y >maxTotal){
              maxTotal = vector.x +vector.y;
              indexMax = i;
          }
        }
        System.out.println(vectors.get(indexMax).x + " " + vectors.get(indexMax).y);
    }
}

package algo;

public class Vecteur2 {
    public double x;
    public double y;

    public Vecteur2(double x, double y ){
        this.x = x;
        this.y = y;
    }

    public double magnitude(){
        return Math.sqrt(x*x + y*y);
    }
}

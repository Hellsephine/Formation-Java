package Vector;


public class Vecteur2 {
    public double x;
    public double y;

    public Vecteur2 (){
        this.x = 0;
        this.y = 0;
    }

    public Vecteur2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(x, 2)+Math.pow(y,2));
    }
     
    @Override
    public String toString(){
        return "V("+x+","+y+")";
    }

    public boolean equals(Vecteur2 other){
        return (this.x == other.x && this.y == other.y);
    }
        
}

package Vector;

public class Vecteur3 extends Vecteur2 {
    double z;

    public Vecteur3(){
        super();
        this.z = 0;
    }

    public Vecteur3(double x, double y){
        super(x, y);
        this.z = 0;
    }

    public Vecteur3(double x, double y, double z){
        super(x,y);
        this.z = 0;
    }

    @Override
    public double magnitude(){
        return Math.sqrt(Math.pow(x, 2)+Math.pow(y,2)+Math.pow(z,2));
    }
    
    @Override
    public String toString(){
        return "V("+x+","+y+","+z+")";
    }

    public boolean equals(Vecteur3 other){
        return ((super.equals(other)) && this.z == other.z);
    }
        
}

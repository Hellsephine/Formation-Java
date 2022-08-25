package projet_java;


public class Vecteur {
    float x;
    float y;

    double magnitude() {
       return Math.sqrt(Math.pow(x, 2)+Math.pow(y,2));
    }
    
    public Vecteur (){
        this.x = 0;
        this.y = 0;
    }

    public Vecteur(float x, float y){
        this.x = x;
        this.y = y;
    }

        
}

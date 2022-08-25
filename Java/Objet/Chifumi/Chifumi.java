package algo;


public class Chifumi {

    int scoreJ1 = 0, scoreJ2 = 0, maxManches = 0, manches = 0;

    public Chifumi(int maxManches){
        this.maxManches = maxManches;
    }
    // Continuer de jouer ?
    public boolean continuer(){
        return manches < maxManches;
    }
    // Jouer une manche
    public void jouer(int j1, int j2){
        if((j1 == 0 && j2 == 2) || (j1 == 1 && j2 == 0) || (j1 == 2 && j2 == 1)){
            System.out.println("C'est gagné !");
            scoreJ1++;
        }
        else if( j1 == j2){
            System.out.println("Egalité !");
        }
        else{
            System.out.println("C'est perdu !");
            scoreJ2++;
        }
        manches++;
    }
    // Remise à zéro
    public void raz(){
        scoreJ1 = 0;
        scoreJ2 = 0;
        manches = 0;
    }

}

package projet_java;

public class Chifumi {
    
    int score_player = 0, score_IA = 0, Maxmanche = 0, manche = 0;
    // constructeur 
    public Chifumi(int Maxmanche) {
        this.Maxmanche = Maxmanche;
    }

    public Chifumi(){}
    
    // pour rejouer
    public boolean continuer(){
        System.out.println("Le score est de : "+score_player+"-"+score_IA);
        return score_player < 3 && score_IA < 3;
    }
    // pour jouer
    public void jouer(int player, int IA){
        int resultat = player-IA;
        if(resultat == 2 || resultat == -1){
            System.out.println("IA remporte la manche");
            score_IA++;
        }
        else if(resultat == 1 || resultat == -2){
            System.out.println("Player remporte la manche");
            score_player++;
        }
        else{
            System.out.println("Egalité");
        }
        manche++;
    }
    // pour reset des scores
    public void reset(){
        score_player = 0;
        score_IA = 0;
        manche = 0;
    }
}

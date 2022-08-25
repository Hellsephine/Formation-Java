package algo;

import java.util.Scanner;

public class Chifumi {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int choixJ = 0, choixIA = 0;
        int scoreJ = 0, scoreIA = 0;

        char continuer = 'O';
        
        while(continuer == 'O'){
            for(int i = 0; i < 3; i++){
                System.out.println("Que voulez vous jouer ? 0 : Pierre, 1 : Feuille, 2 : Ciseaux");
                choixJ = scan.nextInt();
                choixIA = (int)(Math.random() * 3);
    
    
                if((choixJ == 0 && choixIA == 2) || (choixJ == 1 && choixIA == 0) || (choixJ == 2 && choixIA == 1)){
                    System.out.println("C'est gagné !");
                    scoreJ++;
                }
                else if( choixJ == choixIA){
                    System.out.println("Egalité !");
                }
                else{
                    System.out.println("C'est perdu !");
                    scoreIA++;
                }
            }
            System.out.println("Voulez vous rejouer ? O pour rejouer");
            
            continuer = scan.next().charAt(0);
    
        }
        
        
        System.out.println("Score final "+scoreJ+" : "+scoreIA);
        

    }
}

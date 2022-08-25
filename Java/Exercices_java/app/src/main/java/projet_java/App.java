/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package projet_java;

import java.util.Scanner;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //System.out.println("Entrer un nombre");
        exo_vecteur();
        scan.close();
    }

    //#region Pour débute un nouveau exo utiliser la fonction en dessous
    public static void exoX_Y(Scanner scan) {

    }
    //#endregion

    public static void Chifumi_obj(Scanner scan) {
        Chifumi partie = new Chifumi();

        while(partie.continuer()){
            System.out.println("Taper 0, 1 ou 2 pour jouer");
            int player = scan.nextInt();
            partie.jouer(player, (int)(Math.random()*3));
        }
    }

    public static void exo_chifumi(Scanner scan) {
        System.out.println("Entrez pierre, feuille ou ciseaux");
        
        int score_player = 0, score_IA = 0;
        String rejouer = "oui";
    
        while (rejouer.compareTo("oui") == 0){
    
            score_player = 0;
            score_IA = 0;
    
            while(score_player < 3 && score_IA < 3){
    
                int player = 0;
                    switch (scan.next()) {
                        case "pierre" :
                            player = 0;
                            break;
                        case "feuille" :
                            player = 1;
                            break;
                        case "ciseaux" :
                            player = 2;
                            break;
                    }
                
                int IA = (int)(Math.random()*3);
                    if(IA == 0){
                        System.out.println("pierre");
                    }
                    else if(IA == 1){
                        System.out.println("feuille");
                    }
                    else {
                        System.out.println("ciseaux");
                    }
                
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
            }   
            if(score_player < score_IA){
                System.out.println("Gid gud Humain");
            }
            else {
                System.out.println("Tu as gagner... pour cette fois");
            }
            System.out.println("Voulez-vous rejouer ? ");
            rejouer = scan.next();
        }
    }

    public static void exo_vecteur(){

        System.out.println("Entrez X et Y ");

        Scanner x = new Scanner(System.in);
        
        Vecteur v1 = new Vecteur(x.nextFloat(),x.nextFloat());
        double m1 = v1.magnitude();

        System.out.println("La magnitude de votre vecteur est de "+m1);

        x.close();
    }

    public static void exo1_1(Scanner scan) {
        int a = 1;
        int b = a+3;

        a = 3;
        System.out.println(a);
        System.out.println(b);
    }

    public static void exo1_2(Scanner scan) {
        int a = 5;
        int b = 3;
        int c = a+b;

        a = 2;
        c = b-a;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void exo1_3(Scanner scan) {
        int a = 5;
        int b = a+4;

        a = a+1;
        b = a-4;
        System.out.println(a);
        System.out.println(b);
    }

    public static void exo1_4(Scanner scan) {
        int a = 3;
        int b = 10;
        int c = a+b;

        b = a+b;
        a = c;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void exo1_5(Scanner scan) {
        int a = 5;
        int b = 2;

        a = b;
        b = a;
        System.out.println(a);
        System.out.println(b);
    }

    public static void exo1_6(Scanner scan) {
        int a = 2;
        int b = 3;
        int c = a;
        a = b;
        b = c;

        System.out.println(a);
        System.out.println(b);
    }
        
    public static void exo1_8(Scanner scan) {
        String a = "423";
        String b = "12";
        String c = a+b;

        System.out.println(c);

    }   

    public static void exo5_1(Scanner scan) {
        int nombre = scan.nextInt();
        
        while(nombre < 1 || nombre> 3) {
            System.out.println("Votre chiffre n'est pas entre 1 & 3");
            System.out.println("Entrer un autre chiffre");
            nombre = scan.nextInt();
        }
            System.out.println("Votre chiffre est bien entre 1 & 3");
            System.out.println("Maintenant du vent !");
    }

    public static void exo5_2(Scanner scan) {
        int nombre = scan.nextInt();
        
        while(nombre < 10 || nombre > 20) {
            System.out.println("Votre chiffre n'est pas entre 10 & 20");
            
            if(nombre < 10) {
                System.out.println("Entrer un chiffre plus grand");    
                } 
            else if(nombre > 20) {
                System.out.println("Entrer un chiffre plus petit");    
                }           
                nombre = scan.nextInt();
        }
            System.out.println("Votre chiffre est bien entre 10 & 20");
            System.out.println("Maintenant du vent !");
    }

    public static void exo5_3(Scanner scan) {
        int nombre = scan.nextInt();
        int rank = 0;

        while(rank < 10) {
                System.out.println(++nombre);
                rank++;
        }
        scan.close();
    }

    public static void exo5_4(Scanner scan) {

        int nombre = scan.nextInt();

        for(int rank = 0; rank < 10;rank++){
            System.out.println(++nombre);
        }
        scan.close();
    }

    public static void exo5_5(Scanner scan) {
        int nombre = scan.nextInt();
        System.out.println("Voici la table de multiplication de : "+nombre);

        for(int rank = 1; rank < 11;rank++){
            System.out.println(nombre+"*"+rank+"="+nombre*rank);
        }
        scan.close();
    }

    public static void exo5_6(Scanner scan) {
        int nombre = scan.nextInt();
        int total = 0;
        System.out.println("Somme des entiers positifs de "+nombre+"jusqu'a 0 : ");

        for(; nombre > 0; nombre--){
            total = total+nombre;
        }
        
        System.out.println(total);
        scan.close();
    }

    public static void exo5_7(Scanner scan) {
        int nombre = scan.nextInt();
        int facto = 1;
        System.out.print("la factorielle de "+nombre+" est : ");
        for(; nombre >= 1; nombre--) {
            facto = facto*nombre;
        }
        System.out.println(facto);
    }

    public static void exo5_8(Scanner scan) {
        int nombre = scan.nextInt();
        int bigger = 0;
        int pos = 0;
        
        for(int rank = 1; rank < 20; rank++){
            nombre = scan.nextInt();
            if(bigger < nombre){
                bigger = nombre;
                pos = rank;
            }
        }
        System.out.println("Le plus grand de ces nombres est : "+bigger+" à la position : "+pos);
    }

    public static void exo5_9(Scanner scan) {
        int nombre = scan.nextInt();
        int bigger = 0;
        int pos = 1;
        int rank = 1;
        while(nombre != 0){
            nombre = scan.nextInt();
            if(bigger < nombre){
                bigger = nombre;
                rank++;
                pos = rank;
            }
        }
        System.out.println("Le plus grand de ces nombres est : "+bigger+" à la position : "+pos);
    }

    public static void exo5_10(Scanner scan) {
        int prix = scan.nextInt();
        int total = 0;
        int b10 = 0;
        int b5 = 0;

        while(prix != 0){
            total = total+prix;
            prix = scan.nextInt();
        }
        System.out.println("Ce qui fait un total de "+total+" euros ");
        System.out.println("Combien avez-vous en monnaie ? ");

        int monnaie = scan.nextInt();

        while (monnaie >= 10){
            monnaie = monnaie-10;
            b10 = b10+1;
        }

        while (monnaie >= 5){
            monnaie = monnaie-5;
            b5 = b5+1;
        }

        System.out.println("Je doit vous rendre "+b10+" billet(s) de 10 euros et "+b5+" billet(s) de 5 euros ainsi que "+monnaie+"pièce de 1 euros");
    }

    public static void exo5_11(Scanner scan) {
        int n = scan.nextInt();
        int p = scan.nextInt();
        int a = 1;
        int b = 1;

        for(int i = 1; i < p; i++ ){
            a = a*(i+n-p);
            b = b*i;
        }
        System.out.println("Dans l'ordre : une chance sur "+a+" de gagner et ");
        System.out.println("Dans le désordre : une chance sur "+a/b+" de gagner");
    }















    public static void exo7_1(Scanner scan) {
        int[] tab = {12, 13, 14, 15, 16, 17};
        //int[] tab2 = {9, 10, 11, 15, 16, 17};

        boolean cons = true;

        for(int i = 1; i < tab.length; i++){
            if(tab[i-1] != tab[i] - 1)
                cons = false;
        }

        if(cons)
            System.out.println("Tableau consécutif !");
        else
            System.out.println("Tableau non consécutif !");
    }

    public static void exo7_2(Scanner scan) {
        int[] tab = {8, 4, 16, 42, 23, 1};

        for(int i = 0; i < tab.length - 1; i++) {
            for(int j = i+1; j < tab.length;j++){
                if(tab[i] > tab[j]) {
                    int c = tab[i];
                    tab[i] = tab[j];
                    tab[j] = c;
                }
            }
        }
        System.out.println(Arrays.toString(tab));
    }

    public static void exo7_2bis(Scanner scan) {
        int[] tab = {8, 4, 16, 42, 23, 1};
        // Bubble sort
        boolean inverse = true;
        while(inverse){
            inverse = false;
            
            for(int i = 0; i < tab.length - 1; i++){
                if(tab[i] < tab[i+1]){
                int c = tab[i];
                tab[i] = tab[i+1];
                tab[i+1] = c;
                inverse = true;
                }
            }
        }
        System.out.println(Arrays.toString(tab));
    }

    public static void exo7_3(Scanner scan) {
        int[] tab = {8, 4, 16, 42, 23, 1};
        int max = tab.length / 2;

        for(int i = 0;i < max;i++){
            int c = tab[i];
            tab[i] = tab[tab.length - 1 - i];
            tab[tab.length - 1 - i] = c;
        }
        System.out.println(Arrays.toString(tab));
    }

    public static void exo7_4(Scanner scan) {
        int[] tab = {12, 8, 4, 45, 64, 9, 2};

        System.out.println("Quel est l'indice du numéro à supprimer ?");
        int indexToRemove = scan.nextInt();

        int[] tmpTab = new int[tab.length-1];
        int j = 0;

        for(int i = 0; i < tab.length;i++){
            if(i != indexToRemove){
                tmpTab[j] = tab[i];
                j++;
            }
        }
        tab = tmpTab;
        System.out.println(Arrays.toString(tab));
    }

    public static void exo7_5(Scanner scan){
        String[] dico = {"Coucou", "Toto", "Tata", "Titi", "Hello"};
        System.out.println("Entrez un mot à rechercher");
        String recherche = scan.next();

        for(int i = 0; i < dico.length;i++){
            if(recherche.compareTo(dico[i]) == 0){
                System.out.println("Trouvé ! à l'index "+i);
            }
        }
    }

    public static void exo7_6(Scanner scan){
        int[] tab1 = {1, 3, 5, 7, 9, 11};
        int[] tab2 = {2, 2, 4, 6};
        int[] tab3 = new int[tab1.length + tab2.length];
        int j= 0, k = 0;

        for(int i = 0; i < tab3.length; i++){
            if(j < tab1.length && (k >= tab2.length || tab1[j] < tab2[k])){
                tab3[i] = tab1[j];
                j++;
            }
            else {
                tab3[i] = tab2[k];
                k++;
            }
        }
        System.out.println(Arrays.toString(tab3));
    }


}
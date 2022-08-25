/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package projetproduits;


public class App {

    public static void main(String[] args) {

        Produit[] liste = new Produit[4];

        Produit produit1 = new Produit("produit100");
        produit1.getDenomination().modifLibelle("CP", "Crayon a papier");
        produit1.setPrix(1);

        Produit produit2 = new Produit("produit200");
        produit2.getDenomination().modifLibelle("CC", "Crayon de couleur");
        produit2.setPrix(2);

        ProduitSaisonnier produit3 = new ProduitSaisonnier("produit300");


        ProduitPerissable produit4 = new ProduitPerissable("produit400");
        produit4.setDateFab(produit4.getDateFab().minusDays(7));

        ProduitPerissable produit5 = new ProduitPerissable("produit500", "2022-05-21");

        System.out.println(produit4.getDateFab());
        System.out.println(produit5.getDateFab());
        liste[0] = produit1;
        liste[1] = produit2;

        liste[2] = produit3;
        liste[3] = produit4;

        for(Produit prod : liste){
            System.out.println(prod.getDenomination().afficheLiebelle()+" "+prod.getPrix());
        }
    }
}
package grossiste;

public class App {

    public static void main(String[] args) {

        Produit produit1 = new Produit("produit100");// creation du produit
        produit1.modifLibelle("crayon","de papier");//modification du nom du produit
        produit1.setPrix(1);// attribution du prix

        Produit produit2 = new Produit("produit200");
        produit2.modifLibelle("crayon", "de couleur");
        produit2.setPrix(2);

        Produit produit3 = new ProduitPerissable("produit300");
        produit3.modifLibelle("fraise", "du japon");
        produit3.setPrix(3);

        Produit produit4 = new ProduitSaisonnier("produit400");
        produit4.modifLibelle("bonnet", "de bain");
        produit4.setPrix(6);
        ((ProduitSaisonnier)produit4).setRemise(2);// cast de l'attribution de la remise sur le produit

        Produit produit5 = new ProduitFugace("produit500");
        produit5.modifLibelle("Huitres","d'arcachon");
        produit5.setPrix(10);
        ((ProduitFugace)produit5).setRemise(5);
        ((ProduitFugace)produit5).setSaison(Periode.hiver);



        Produit[] liste = new Produit[5];//creation d'un tableau avec les 4 produit
        liste[0] = produit1;
        liste[1] = produit2;
        liste[2] = produit3;
        liste[3] = produit4;
        liste[4] = produit5;

        for(Produit produit : liste){// recuperation de la date depuis la class produit perissable enfant de produit
            if(produit instanceof ProduitPerissable){
                System.out.println(((ProduitPerissable)produit).getFabrication());
            }
            produit.getPrix();
            System.out.println(produit.afficheLibelle()+" - "+produit.getPrix());

            if(produit instanceof Saison){
                System.out.println(((Saison) produit).getSaison());
            }
        }
        
        //affichage des produit
        System.out.println(produit1.getCode()+" "+produit1.getPrix()+" eur"+produit1.afficheLibelle());
        System.out.println(produit2.getCode()+" "+produit2.getPrix()+" eur "+produit2.afficheLibelle());
        System.out.println(produit3.getCode()+" "+produit3.getPrix()+" eur "+produit3.afficheLibelle()+" "+((ProduitPerissable)produit3).getFabrication());
        System.out.println(produit4.getCode()+" "+produit4.getPrix()+" eur "+produit4.afficheLibelle()+" ");
        System.out.println(produit5.getCode()+" "+produit5.getPrix()+" eur "+produit5.afficheLibelle()+" "+((ProduitPerissable)produit5).getFabrication()+" "+((Saison)produit5).getSaison());
        
    }


}

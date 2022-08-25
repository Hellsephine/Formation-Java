package mini_rpg_version_K;

import java.util.*;

import mini_rpg_version_K.Utilitaire.DBManager;

class App {

    public static Scanner scan = new Scanner(System.in);
    public static Armure[] availableArmors = new Armure[9];
    public static Arme[] availableWeapons = new Arme[9];
    public static AObjet[] availableItems = new AObjet[19];
    public static Personnage[] availableMonstre = new Personnage[5];
    
    public static void main(String[] args) {
        DBManager.init();
        //#region Création du héro
        System.out.println("Quel est votre Nom ?");
        String nom = scan.next();

        Personnage hero = new Personnage(1);
        hero.setNom(nom);
        hero.setWeapon(new Arme(1));
        hero.setArmor(new Armure(1));
        hero.save();

        //#endregion

        //#region Informations de bases
        System.out.println("Enchanté(e) "+hero);
        System.out.println("Vous avez : "+hero.getPv()+" pv");
        System.out.println("Arme équipé : "+hero.weapon);
        System.out.println("Armure équipé : "+hero.armor);
        //#endregion
        Personnage p2 = new Personnage("Gobelin", 10, 1, 2);
        //#region Lancement des combats
        //for(Personnage p2 : availableMonstre ){
            System.out.println(" ");
            System.out.println("Vous rencontrez "+p2.getNom()+", armé de : "+p2.getWeapon()+"("+p2.getWeapon().getDmg()+" dmg)"+", protégé par : "+p2.getArmor()+"("+p2.getArmor().getDef()+" def)");
            combatDnd(hero,p2);
        //}
        //#endregion
    }

    //#region Methode de Combat

    /**
     * Sert a faire combattre 
     * @param p1 appel le héro
     * @param monstres appel la listes des adversaire
     */
    public static void combattre(Personnage p1, Personnage p2){

        //#region Variables
        int choix;
        
        //#endregion

        while(p1.getPv() > 0 && p2.getPv() > 0){
            System.out.println("Que voulez-vous faire ? ");
            System.out.println("1 pour combattre, 2 ouvrir inventaire");
            choix = scan.nextInt();
            
            if(choix == 1){
                p2.subir_attaque(p1.attaquer());
                if(p2.getPv()>0)
                    p1.subir_attaque(p2.attaquer());
            }
            else if(choix == 2){

                boolean havePotion = false;

                for(AObjet potionSoin : p1.getInventaire()){
                    if(potionSoin instanceof Potion){
                        havePotion = true;
                        ((Potion)potionSoin).consommer(p1);
                        p1.inventaire.remove(potionSoin);
                        System.out.println("Potion de Soin consommer, vous avez maintenant "+p1.getPv()+" pv");
                        break;
                    }
                }
                if(!havePotion){
                    System.out.println("Vous n'avez plus de Potion");
                }
            }
            else {
                System.out.println("Commande non reconnue, entrer une commande valide");
            }
            
        }
        System.out.println("Le vainqueur est : "+((p1.getPv()>0) ? p1 : p2));
    }
    //#endregion

    //#region Nouvelle méthode de combat 
    public static void combatDnd(Personnage p1, Personnage p2){

        //#region Variables
        int choix;
        int damage;
        //#endregion

        while(p1.getPv() > 0 && p2.getPv() > 0){
            System.out.println("Que voulez-vous faire ? ");
            System.out.println("1 pour combattre, 2 se soigner");
            choix = scan.nextInt();
            Random rand = new Random();
            int d20 = rand.nextInt(19)+1;

            if(choix == 1){
                
                if(d20 < p2.armor.getDef()){
                    damage = 0;
                }
                else{
                    int d6 = rand.nextInt(5)+1;
                    if (d20 == 20)
                        damage = d6*2;
                    else
                        damage = d6;
                }
                p2.pv -= damage;
            
                if(p2.pv > 0){
                    if(d20 < p1.armor.getDef()){
                        damage = 0;
                    }
                    else{
                        int d6 = rand.nextInt(5)+1;
                        if (d20 == 20)
                            damage = d6*2;
                        else
                            damage = d6;
                    }
                    p1.pv -= damage;
                }
            }
            else if(choix == 2){

                boolean havePotion = false;

                for(AObjet potionSoin : p1.getInventaire()){
                    if(potionSoin instanceof Potion){
                        havePotion = true;
                        ((Potion)potionSoin).consommer(p1);
                        p1.inventaire.remove(potionSoin);
                        System.out.println("Potion de Soin consommer, vous avez maintenant "+p1.getPv()+" pv");
                        break;
                    }
                }
                if(!havePotion){
                    System.out.println("Vous n'avez plus de Potion");
                }
            }
            else {
                System.out.println("Commande non reconnue, entrer une commande valide");
            }
        }
        System.out.println("Le vainqueur est : "+((p1.getPv()>0) ? p1 : p2));
    }
    //#endregion

}

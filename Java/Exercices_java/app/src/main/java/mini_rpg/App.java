package mini_rpg;

import java.util.*;

//import com.mysql.cj.xdevapi.Result;
//import com.mysql.cj.xdevapi.Statement;

import mini_rpg.Utilitaire.DBManager;

//#region A faire :
/*
 * remplir les method get et save de potion
 * changer le systeme de combat avec les dé !
 * 
 */
//#endregion

//#region Exemple :
/* création,ajout et equipement d'arme et armure
 * Arme arme = new Arme("Epée rouillé",0, 20, 51);
            hero.inventaire.add(arme);
            Personnage.poing.unequip(hero);
            arme.equip(hero);
            Armure armure = new Armure("Cartons scotchés",10, 15);
            hero.inventaire.add(armure);
            Personnage.aucune.unequip(hero);
            armure.equip(hero);
 */

/* Liste des mobs par ArrayList sans aléatoire
 *      public static void listeMonstres(){
            monstres.add(new Personnage("Slime", 25, 3,new Armure("Aucune",0, 0), new Arme("Crachat",0, 10, 10)));
            monstres.add(new Personnage("Gobelin", 30, 6,new Armure("Cotte de maille",20, 15), new Arme("Dague",5, 10, 10)));
            monstres.add(new Personnage("Bandit", 40, 6,new Armure("Haillon",3, 20), new Arme("Epee en fer",5, 15, 10)));
            monstres.add(new Personnage("Orc", 60, 7,new Armure("Armure en fer ",30, 25), new Arme("Marteau de guerre",10, 20, 10)));
            monstres.add(new Personnage("Dragonnet", 80, 9,new Armure("Ecaille",0, 30), new Arme("Souffle de feu",0, 25, 10)));
        }  
 */

/* Liste de monstres par tableau
 *      Personnage[] monstres = new Personnage[5]{
            monstres[0] = new Personnage("Slime", 25, 3,new Armure("Aucune",0, 0), new Arme("Crachat",0, 10, 10));
            monstres[1] = new Personnage("Gobelin", 30, 6,new Armure("Cotte de maille",20, 15), new Arme("Dague",5, 10, 50));
            monstres[2] = new Personnage("Bandit", 40, 6,new Armure("Haillon",3, 20), new Arme("Epee en fer",5, 15, 10));
            monstres[3] = new Personnage("Orc", 60, 7,new Armure("Armure en fer ",30, 25), new Arme("Marteau de guerre",10, 20, 10));
            monstres[4] = new Personnage("Dragonnet", 80, 9,new Armure("Ecaille",0, 30), new Arme("Souffle de feu",0, 25, 10));
        }
 */

 /* Generateur de Dé 
  *  public static void d4(){
        Random d4 = new Random();
        System.out.println(d4.nextInt(3)+1);
    }
    public static void d6(){
        Random d6 = new Random();
        System.out.println(d6.nextInt(5)+1);
    }
    public static void d8(){
        Random d8 = new Random();
        System.out.println(d8.nextInt(7)+1);
    }
    public static void d10(){
        Random d10 = new Random();
        System.out.println(d10.nextInt(9)+1);
    }
    public static void d12(){
        Random d12 = new Random();
        System.out.println(d12.nextInt(11)+1);
    }
    public static void d20(){
        Random d20 = new Random();
        System.out.println(d20.nextInt(19)+1);
    }
    public static void d20(){
        Random d20 = new Random();
        System.out.println(d20.nextInt(19)+1);
    }
    
  */
//#endregion

public class App {

    public static Scanner scan = new Scanner(System.in);
    //public static ArrayList<Personnage> monstres = new ArrayList<Personnage>();
    public static Armure[] availableArmors = new Armure[9];
    public static Arme[] availableWeapons = new Arme[9];
    public static AObjet[] availableItems = new AObjet[19];
    public static Personnage[] availableMonstre = new Personnage[5];
    
    public static void main(String[] args) {
        DBManager.init();
        //#region ajout d'arme a la  BDD :
        /*
        Arme arme3 = new Arme("Hache en mousse", 40, 10, 3);
        arme3.save();
        */
        //#endregion

        //#region ajout d'armure a la BDD :
        /*
        Armure armure3 = new Armure(Armure en mousse, 3, 40);
        armure3.save();
        */
        //#endregion

        //listeMonstres();
        tableauDeMonstres();

        //#region Création du héro
        System.out.println("Quel est votre Nom ?");
        String nom = scan.next();

        Personnage hero = new Personnage(1);
        hero.setNom(nom);
        hero.setWeapon(new Arme(3));
        hero.save();
        

        //ajout des items de bases
        Potion potionSoin =new Potion("Potion de Soin", 1);
        hero.inventaire.add(potionSoin);
        hero.inventaire.add(potionSoin);
        //#endregion

        //#region Informations de bases
        System.out.println("Enchanté(e) "+hero);
        System.out.println("Vous avez : "+hero.getPv()+" pv");
        System.out.println("Statistique : "+hero.getForce()+" force");
        System.out.println("Arme équipé : "+hero.weapon);
        System.out.println("Armure équipé : "+hero.armor);
        //#endregion

        //#region Lancement des combats
        for(Personnage p2 : availableMonstre ){
            System.out.println(" ");
            System.out.println("Vous rencontrez "+p2.getNom()+", armé de : "+p2.getWeapon()+"("+p2.getWeapon().getDmg()+" dmg)"+", protégé par : "+p2.getArmor()+"("+p2.getArmor().getDef()+" def)");
            combattre(hero,p2);
        }
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

    //#region Generateurs de mobs 
    public static void tableauDeMonstres(){
                       
        int randomPoids = (int)Math.random() * 100;
        int randomDef = (int)Math.random() * 100;
        int randomDmg = ((int)Math.random() * 40)+10;

        String[] typesArmor1 = new String[]{"Cotte " ,"Chemise " ,"Cuirasse " ,"Veste " ,"Costar-Cravatte ","Maillot ","Manteau ","Culotte ","Doudou ","Argument "};
        String[] typesArmor2 = new String[] {"de Paille", "de Maille", "Matelassée", "de Plastique", "du RSA", "Rembourré", "de Plaques", "Elementaire", "Diplomatique", "Divine"};
        for(int i = 0; i < 9; i++){
            availableArmors[i] = new Armure(typesArmor1[i] +typesArmor2[i] ,randomPoids ,randomDef);
            availableArmors[i].setDef((int)(Math.random() * 5 * (i+1)));
        }

        String[] typesWeapon1 = new String[] {"Dague ", "Epée ", "Glaive ", "Masse ", "Javelin ", "Lance ", "Serpe", "Accusation ", "Excuse "};
        String[] typesWeapon2 = new String[] {"de Bois", "de Pierre", "de Fer", " Barban", "de Droite", "de Gauche", "Communiste","Capitaliste", "d'Ecolo", };
        for(int i = 0; i < 9; i++){
            availableWeapons[i] = new Arme(typesWeapon1[i] +typesWeapon2[i] ,randomPoids ,randomDmg ,randomDef);
            availableWeapons[i].setDmg((int)(Math.random() * 5 * (i+1)));
            availableWeapons[i].setCc((int)Math.random() * 5 * (i+1) / 100);
        }

        String[] typesMonstre1 = new String[] {"Slime ", "Gobelin ","Elfe ","Orc ","Nain ","Dragonnet ","Macron "};
        String[] typesMonstre2 = new String[] {"Pervert","Timide","Discret","En marche","Républicain","Inquiet","Bourré"};
        for(int i = 0;i < 5; i++){
            availableMonstre[i] = new Personnage(typesMonstre1[(int)(Math.random() * 6)]+typesMonstre2[(int)(Math.random() * 6)] ,1, 1, availableArmors[(int)(Math.random() * 9)] ,availableWeapons[(int)(Math.random() * 9)]);
            availableMonstre[i].setPv((int)(Math.random() * 100) + 40);
            availableMonstre[i].setForce((int)(Math.random() * 10 * (i+1)));
        }
    }
    //#endregion

}
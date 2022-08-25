package mini_rpg_version_K;

import java.util.Random;

public class Potion extends AObjet implements Consommables{
    
    //#region Variables
    Random rand = new Random();
    int d10 = rand.nextInt(9)+1;
    protected int pvRendu = d10;
    //#endregion
   
    //#region Constructeur
    public Potion(String nom, int poids) {
        super(nom, poids);
    }
    //#endregion

    //#region GETTER & SETTER
    public int getPvrendu() {
        return pvRendu;
    }

    public void setPvrendu(int pvrendu) {
        this.pvRendu = pvrendu;
    }

    @Override
    public boolean get(int id) {
        return false;
    }

    @Override
    public boolean save() {
        return false;
    }
    //#endregion

    //#region Specification de l'interface Consommables
    @Override
    public boolean consommer(Personnage hero) {
        hero.setPv(hero.getPv()+ pvRendu);
        return false;
    }
    //#endregion

  

}

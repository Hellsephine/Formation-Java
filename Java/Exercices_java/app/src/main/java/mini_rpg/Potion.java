package mini_rpg;

public class Potion extends AObjet implements Consommables{
    
    //#region Variables
    protected int pvRendu = 50;
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
    //#endregion

    //#region Specification de l'interface Consommables
    @Override
    public boolean consommer(Personnage target) {
        target.setPv(target.getPv()+ pvRendu);
        return false;
    }
    //#endregion

    @Override
    public boolean get(int id) {
        return false;
    }

    @Override
    public boolean save() {
        return false;
    }

}

/* 
for(int i = 0; i < availableItems.length; i++){
    availableItems[i] = new Potion("Potion "+(i+1)*5+"PV",1);
    ((Potion)availableItems[i]).setPvrendu((i+1)*5);
}
*/

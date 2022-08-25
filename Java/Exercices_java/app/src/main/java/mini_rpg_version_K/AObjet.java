package mini_rpg_version_K;

import mini_rpg.Utilitaire.Model;
public abstract class AObjet extends Model {
    
    //#region Variables
    protected String nom;
    protected int poids;
    protected String icone;
    //#endregion

    //#region Constructeur
    public AObjet(String nom, int poids) {
        this.nom = nom;
        this.poids = poids;
    }
    //#endregion

    //#region GETTER & SETTER
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoids() {
        return poids;
    }
    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getIcone() {
        return icone;
    }
    public void setIcone(String icone) {
        this.icone = icone;
    }
//endregion
}

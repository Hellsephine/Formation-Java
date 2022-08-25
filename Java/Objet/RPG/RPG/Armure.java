package exorpg.RPG;

public class Armure {
    protected String nom;
    protected int defense = 1;

    public Armure(String nom){
        this.nom = nom;
    }

    public Armure(String nom, int defense){
        this.nom = nom;
        this.defense = defense;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    
}

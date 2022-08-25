package exorpg.RPG;

public class Arme {
    String nom;
    int degats = 0;
    float critique = 0;

    public Arme(String nom){
        this.nom = nom;
    }
    public Arme(String nom, int degats, float critique){
        this.nom = nom;
        this.degats = degats;
        this.critique = critique;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getDegats() {
        return degats;
    }
    public void setDegats(int degats) {
        this.degats = degats;
    }
    public float getCritique() {
        return critique;
    }
    public void setCritique(float critique) {
        this.critique = critique;
    }
    
}

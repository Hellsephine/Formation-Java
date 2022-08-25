package exorpg.RPG;

public class Personnage {
    protected String nom;
    protected int pv = 50;
    protected int force = 1;

    protected Armure armor;
    protected Arme equipedWeapon;

    public Armure getArmor() {
        return armor;
    }

    public void setArmor(Armure armor) {
        this.armor = armor;
    }
    

    public Arme getEquipedWeapon() {
        return equipedWeapon;
    }

    public void setEquipedWeapon(Arme equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }

    public Personnage(String nom){
        this.nom = nom;
    }

    public Personnage(String nom, int pv, int force){
        this.nom = nom;
        this.pv = pv;
        this.force = force;
    }

    public String toString(){
        return this.nom+"("+this.pv+")";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }
    
    public float attaquer(Personnage autre){
        int degats = equipedWeapon.getDegats();
        if(Math.random() < (equipedWeapon.getCritique() + this.force / 100)){
            degats *= 2;
        }

        degats *= (1 + 0.1f * this.force);
        System.out.println(this.nom+" utilise "+equipedWeapon.getNom()+ " et tente d'infliger "+degats+" a "+autre.getNom());
        
        autre.prendreCoup(degats);

        return degats;
    }
    public float prendreCoup(float degats){
        degats *= (1-(this.armor.getDefense()/100.0f));
        this.pv -= degats;
        System.out.println(this.nom+ " reçoit "+ degats +" ! Il lui reste "+this.pv+" points de vie !");
        return degats;
    }
}

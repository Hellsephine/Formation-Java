package mini_rpg_version_K;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import mini_rpg_version_K.Utilitaire.DBManager;
import mini_rpg_version_K.Utilitaire.Model;


public class Personnage extends Model {

    //#region Variables
    protected int pv;
    protected String nom;
    protected Armure armor;
    protected Arme weapon;
    protected int id;
    public ArrayList<AObjet> inventaire = new ArrayList<AObjet>();
    protected int id_arme;
    protected int id_armure;
    //public static Armure aucune = new Armure("Aucune",10, 10);
    //public static Arme poing = new Arme("Poing",0, 10);
    //#endregion

    //#region Constructeur
    public Personnage(String nom, int pv, Armure armor, Arme weapon){
        this.nom = nom;
        this.pv = pv;
        this.armor = armor;
        this.weapon = weapon;
    }

    public Personnage(String nom, int pv , int id_arme , int id_armure){
        this.nom = nom;
        this.pv = pv;
        this.weapon = new Arme(id_arme);
        this.armor = new Armure(id_armure);
    
    }
    //#endregion
    
    public String toString(){
        return getNom();
    }

    //#region GETTER & SETTER
    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Arme getWeapon() {
        return weapon;
    }

    public void setWeapon(Arme weapon) {
        this.weapon = weapon;
    }

    public Armure getArmor() {
        return armor;
    }

    public void setArmor(Armure armor) {
        this.armor = armor;
    }

    public ArrayList<AObjet> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ArrayList<AObjet> inventaire) {
        this.inventaire = inventaire;
    }


//#endregion

    //#region methode d'attaque infligé et de dmg subit

    /**
     * methode d'attaque
     * @return Qte dmg
     */
    public String attaquer(){
        String degat;
        
        degat = weapon.getDmg();

        System.out.println(getNom()+" utilise "+weapon.getNom()+" et tente d'infliger "+degat+" dégâts ! ");
        return degat;
    }

    /**
     * methode de dmg subit
     * @param degat Qte dmg
     * @return Qte dmg subit
     */
    public float subir_attaque(String degat){
        float degat_subit =6*(1-this.armor.getDef()/100);
        this.pv -= degat_subit;
        System.out.println(this.nom+" reçoit "+degat_subit+" il lui reste "+this.pv+" pv !");
        return degat_subit;
    }
    //#endregion

    //#region Gestion d'ajout et retrait d'inventaire

    /**
     * Sert a ajouter un objet a l'inventaire
     * @param item C'est un objet
     * @return
     */
    public boolean ajouterItem(AObjet item){
        return inventaire.add(item);
    }
    /**
     * Sert a retirer un objet de l'inventaire
     * @param item C'est un objet
     * @return
     */
    public boolean retirerItem(AObjet item){
        return inventaire.remove(item);
    }
    //#endregion

    public Personnage(int id){
        try{
            ResultSet resultat = DBManager.execute("SELECT * FROM personnage WHERE id_personnage = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.pv = resultat.getInt("pv");
                this.id = id;
                this.id_arme = resultat.getInt("id_arme");
                this.weapon = new Arme(id_arme);
                this.id_armure = resultat.getInt("id_armure");
                this.armor = new Armure(id_armure);
            }
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    //#region Methode de Save
    @Override
    public boolean save(){
        String sql;
        if(this.id!= 0)
            sql = "UPDATE personnage SET nom = ?, pv = ?, id_arme = ?, id_armure = ? WHERE id_personnage = ?";
        else
            sql = "INSERT INTO personnage (nom, pv, id_arme, id_armure) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement stmt = DBManager.conn.prepareStatement(sql);
            stmt.setString(1, this.nom);
            stmt.setInt(2, this.pv);
            stmt.setInt(3, this.id_arme);
            stmt.setInt(4, this.id_armure);
            if(id != 0)
                stmt.setInt(5, this.id);
            return stmt.execute();
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
    }
    //#endregion

    public boolean get(int id){
        try{
            ResultSet resultat = DBManager.execute("SELECT * FROM personnage WHERE id_personnage = ?"+id);
            if(resultat.next()){
                this.id = id;
                this.nom = resultat.getString("nom");
                this.pv = resultat.getInt("pv");
                this.armor = new Armure(resultat.getInt("id_armure"));
                this.weapon = new Arme(resultat.getInt("id_arme"));
                return true;
            }
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return false;
    }

    public boolean get(){
        try{
            ResultSet resultat = DBManager.execute("SELECT * FROM personnage WHERE id_personnage = ?"+this.id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.pv = resultat.getInt("pv");
                this.armor = new Armure(resultat.getInt("id_armure"));
                this.weapon = new Arme(resultat.getInt("id_arme"));
                return true;
            }
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return false;
    }

    
}

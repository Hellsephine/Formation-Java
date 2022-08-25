package mini_rpg_version_K;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mini_rpg_version_K.Utilitaire.*;

public class Arme extends AObjet implements IEquipable {

    //#region Variables
    protected String dmg;
    protected int id;
    //#endregion

    //#region Constructeur
    public Arme(String nom,int poids, String dmg){
        super(nom,poids);
        this.dmg = dmg;
    }
    //#endregion

    public String toString(){
        return getNom();
    }
    
    //#region GETTER & SETTER
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDmg() {
        return dmg;
    }
    public void setDmg(String dmg) {
        this.dmg = dmg;
    }
    //endregion

    //#region Specification de l'interface Equipable
    @Override
    public boolean equip(Personnage target){
        if(target.getWeapon() != null)
            target.ajouterItem(target.getWeapon());
        if(target.retirerItem(this)){
            target.setWeapon(this);
            return true;
        }
        return false;
    }
    

    @Override
    public boolean unequip(Personnage target) {
        if(target.getWeapon() == this){
            target.ajouterItem(this);
            target.setWeapon(null);
            return true;
        }
        return false;
    }
    //#endregion

    public Arme(int id){
        super("",id);
        try{
            ResultSet resultat = DBManager.execute("SELECT * FROM arme WHERE id_arme = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.dmg = resultat.getString("dmg");
                this.poids = resultat.getInt("poids");
                this.id = id;
            }
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public boolean get(int id){
        try{
            ResultSet resultat = DBManager.execute("SELECT * FROM arme WHERE id_arme = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.dmg = resultat.getString("dmg");
                this.poids = resultat.getInt("poids");
                this.id = id;
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
            ResultSet resultat = DBManager.execute("SELECT * FROM arme WHERE id_arme = "+this.id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.dmg = resultat.getString("dmg");
                this.poids = resultat.getInt("poids");
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

    public boolean save(){
        String sql;
        if(this.id != 0)
            sql = "UPDATE arme "+
                    "SET nom = ?, dmg = ?, poids = ?"+
                    "WHERE id_arme = ?";
        else
            sql = "INSERT INTO arme (nom, dmg, poids"+
                        "VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement stmt = DBManager.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, this.nom);
            stmt.setString(2, this.dmg);
            stmt.setInt(3, this.poids);
            if(id != 0)
                stmt.setInt(4, this.id);

            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();
            if(this.id == 0 && keys.next()){
                this.id = keys.getInt(1);
                return true;
            }
            else if(this.id != 0)
                return true;
            else
                return false;

        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
    }

}

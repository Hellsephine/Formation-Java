package mini_rpg;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mini_rpg.Utilitaire.*;

public class Arme extends AObjet implements IEquipable {

    //#region Variables
    protected int dmg;
    protected int cc;
    protected int id;
    //#endregion

    //#region Constructeur
    public Arme(String nom, int dmg, int cc,int poids){
        super(nom,poids);
        this.dmg = dmg;
        this.cc = cc;
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

    public int getDmg() {
        return dmg;
    }
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
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
        super("",0);
        try{
            ResultSet resultat = DBManager.execute("SELECT * FROM arme WHERE id_arme = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.dmg = resultat.getInt("degats");
                this.cc = resultat.getInt("critique");
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

    @Override
    public boolean get(int id){
        try{
            ResultSet resultat = DBManager.execute("SELECT * FROM arme WHERE id_arme = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.dmg = resultat.getInt("degats");
                this.cc = resultat.getInt("critique");
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
    //#region Ancienne version de save arme
    /*
    public boolean save(){
        String sql;
        if(this.id != 0){
            sql = "UPDATE arme"+
                    "SET nom = '"+this.nom+"', "+
                    "degats = '"+this.dmg+", "+
                    "critique = '"+this.cc+"', "+
                    "poids = '"+this.poids+" "+
                    "WHERE id_arme = "+id;
        }
        else{
            sql = "INSERT INTO arme (nom, degats, critique, poids)"+
                    "VALUES("+
                "'"+this.nom+"',"+
                ""+this.dmg+","+
                ""+this.cc+"',"+
                ""+this.poids+")";
        }
        return (DBManager.executeUpdate(sql) > 0);
        
    }
    */
    //#endregion
   
    @Override
    public boolean save(){
        String sql;
        if(this.id!= 0)
            sql = "UPDATE arme SET nom = ?, degats = ?, critique = ?, poids = ? WHERE id_arme = ?";
        else
            sql = "INSERT INTO arme (nom, degats, critique, poids) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement stmt = DBManager.conn.prepareStatement(sql);
            stmt.setString(1, this.nom);
            stmt.setInt(2, this.dmg);
            stmt.setInt(3, this.cc);
            stmt.setInt(4, this.poids);
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
}

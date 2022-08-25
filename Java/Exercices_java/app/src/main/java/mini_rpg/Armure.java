package mini_rpg;
import java.sql.*;

import mini_rpg.Utilitaire.DBManager;
public class Armure extends AObjet implements IEquipable{

    //#region Variables
    protected int def;
    protected int id;
    //#endregion

    //#region Constructeur
    public Armure(String nom,int poids, int def){
        super(nom,poids);
        this.nom = nom;
        this.def = def;
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

    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
//endregion

    //#region Specification de l'interface Equipable
@Override
    public boolean equip(Personnage target){
        if(target.getArmor() != null)
            target.ajouterItem(target.getArmor());
        if(target.retirerItem(this)){
            target.setArmor(this);
            return true;
        }
        return false;
    }
    

    @Override
    public boolean unequip(Personnage target) {
        if(target.getArmor() == this){
            target.ajouterItem(this);
            target.setArmor(null);
            return true;
        }
        return false;
    }
    //#endregion

    public Armure(int id){
        super("",0);
        try{
            ResultSet resultat = DBManager.execute("SELECT * FROM armure WHERE id_armure = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.def = resultat.getInt("defense");
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
            ResultSet resultat = DBManager.execute("SELECT * FROM armure WHERE id_armure = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.def = resultat.getInt("defense");
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
    //#region Ancienne method de save armure
    /*
    public boolean save(){
        String sql;
        if(this.id != 0){
            sql = "UPDATE armure"+
                    "SET nom = '"+this.nom+"',"+
                    "degats = '"+this.def+", "+
                    "poids = '"+this.poids+", "+
                    "WHERE id_armure = "+id;
        }
        else{
            sql = "INSERT INTO armure (nom, defense, poids)"+
                    "VALUES("+
                "'"+this.nom+"',"+
                ""+this.def+","+
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
            sql = "UPDATE armure SET nom = ?, defense = ?, poids = ? WHERE id_armure = ?";
        else
            sql = "INSERT INTO armure (nom, defense, poids) VALUES (?, ?, ?)";
        try{
            PreparedStatement stmt = DBManager.conn.prepareStatement(sql);
            stmt.setString(1, this.nom);
            stmt.setInt(2, this.def);
            stmt.setInt(3, this.poids);
            if(id != 0)
                stmt.setInt(4, this.id);
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

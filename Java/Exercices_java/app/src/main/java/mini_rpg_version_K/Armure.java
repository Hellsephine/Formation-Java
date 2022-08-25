package mini_rpg_version_K;
import java.sql.*;

import mini_rpg_version_K.Utilitaire.DBManager;
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
        super("",id);
        try{
            ResultSet resultat = DBManager.execute("SELECT * FROM armure WHERE id_armure = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.def = resultat.getInt("def");
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
            ResultSet resultat = DBManager.execute("SELECT * FROM armure WHERE id_armure = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.def = resultat.getInt("def");
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
            ResultSet resultat = DBManager.execute("SELECT * FROM armure WHERE id_armure = "+this.id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.def = resultat.getInt("def");
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
            sql = "UPDATE armure "+
                    "SET nom = ?, def = ?, poids = ?"+
                    "WHERE id_armure = ?";
        else
            sql = "INSERT INTO armure (nom, def, poids)"+
                        "VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement stmt = DBManager.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, this.nom);
            stmt.setInt(2, this.def);
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

package mini_rpg.Utilitaire;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Requete {

    public static void main(String[] args) {

        Connection conn = null;
        String user = "M2I";
        String password = "H3ll0M2I";
        String server = "51.68.227.19";
        String database = "rpg_pierre";

        try{
            conn =                                                
            DriverManager.getConnection("jdbc:mysql://"+server+"/"
                                            +database, user, password);

        Statement stmt = conn.createStatement();
        //stmt.executeUpdate() pour update ou insert dans une table //PAS DE WHILE APRES
        //ResultSet resultat = stmt.executeQuery(afficher une requete)// while(resultat.next()){}
        ResultSet resultat = stmt.executeQuery("SELECT * FROM armures;");

        while(resultat.next()){
            System.out.println(resultat.getString("nom")+" "+resultat.getInt("id_armure"));
            System.out.println(resultat.getInt("defense")+" "+resultat.getInt("poids"));

        }
            // do something

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
            System.out.println("SQLState" + ex.getSQLState());
            System.out.println("VendorError"+ ex.getErrorCode());
        }
    }
}
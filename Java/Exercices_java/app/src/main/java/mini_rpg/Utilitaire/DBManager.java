package mini_rpg.Utilitaire;

import java.sql.*;

public class DBManager {
    public static Connection conn = null;
    private static String user = "M2I";
    private static String password = "H3ll0M2I";
    private static String server = "51.68.227.19";
    private static String database = "rpg_pierre";

    //#region exemple de Query :
    
    // int resultat = DBManager.executeUpdate("UPDATE nom de la table SET ce qu'il faut modifier WHERE ce qu'il été a la base");
    
    // int resultat = DBManager.executeUpdate("DELETE FROM nom de la table WHERE ligne exacte a supprimer");
   
    // Resultat resultat = DBManager.execute("INSERT INTO nom de la table VALUES valeurs de la ligne ;")
    
    // Resultat resultat = DBManager.execute("SELECT * FROM nom de la table;")
    // while(resultat.next()){
    //      System.out.println(resultat.getString("colone a afficher")+" "+resultat.getInt("autre colone a afficher"));

    //#endregion
    
    public static void init(){
        try {
            DBManager.conn =
            DriverManager.getConnection("jdbc:mysql://"+DBManager.server+"/"
                                            +DBManager.database, user, password);
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void close(){
        try{
            DBManager.conn.close();
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static ResultSet execute(String sql){
        ResultSet test = null;
        try {
            Statement stmt = DBManager.conn.createStatement();
            test = stmt.executeQuery(sql);
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return test;
    }
    public static int executeUpdate(String sql){
        int test = -1;
        try {
            Statement stmt = DBManager.conn.createStatement();
            test = stmt.executeUpdate(sql);
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return test;
    }

}

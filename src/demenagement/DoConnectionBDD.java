package demenagement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vince
 */
public class DoConnectionBDD {

    public static java.sql.Connection db = null;
    public static int nIdDem = 0;
    public static int nIdmeuble = 0;

    public static boolean DoConnectionJDBC() {
        try {

            Class.forName("org.mariadb.jdbc.Driver");
            db = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/pisano", "pisano", "crotone10");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());//renvoie un string 
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();// ecrit  mais pas très utile
            return false;
        }

    }

    public static void DoExecuteSQL(String strRequete) {

        try {
            PreparedStatement requete = db.prepareStatement(strRequete);
            requete.executeUpdate();	// pour un delete insert ou update 	
            //System.out.println("reussi insert");
            requete.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());//renvoie un string 
        }
    }

    public static int nextMaxId(String sTable, String sColonne) {

        try {
            String sRequete = "SELECT MAX(" + sColonne + ") from " + sTable;
            //infoBox(sRequete);
            Statement requete = db.createStatement();
            ResultSet rs = requete.executeQuery(sRequete);
            rs.next();
            int res = rs.getInt(1) + 1;

            rs.close();
            requete.close();
            //  System.out.println(res);
            return res;
        } catch (SQLException e) {
            return 1;
        }

    }

}

package demenagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Outil {

    public static final String TitleApp = "I-Demenageur";
    public static String meubleDemont = "Chaise";

    public static boolean estUnEntier(String chaine) {
        try {
            Integer.parseInt(chaine);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean isEmpty(String c) {
        return c == null || c.length() == 0;// renvoie isEmpty true 
    }

    public static boolean NoEmpty(String c) {
        return !isEmpty(c);// renvoie NoEmpty true
    }

    public static void errorBox(String message) {
        JOptionPane.showMessageDialog(null, message, "I-Demenageur", JOptionPane.ERROR_MESSAGE);
    }

    public static void infoBox(String message) {
        JOptionPane.showMessageDialog(null, message, "I-Demenageur", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warningBox(String message) {
        JOptionPane.showMessageDialog(null, message, "I-Demenageur", JOptionPane.WARNING_MESSAGE);
    }

    public static void questionBox(String message) {
        JOptionPane.showMessageDialog(null, message, "I-Demenageur", JOptionPane.QUESTION_MESSAGE);
    }

    public static void OptionDialog(String message) {
        Object[] options = {"   OK   "};
        JOptionPane.showOptionDialog(null, message, "I-Demenageur", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
    }

    public static boolean ConfirmDialog(String message) {

        if (JOptionPane.showConfirmDialog(null, message, Outil.TitleApp, JOptionPane.YES_NO_OPTION) == 0)// yes 
        {
            return true;
        }
        return false;
    }
}

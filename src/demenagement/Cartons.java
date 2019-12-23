package demenagement;

import demenagement.Outil;
import static demenagement.DoConnectionBDD.db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cartons extends javax.swing.JFrame implements ActionListener, ItemListener {

    public Cartons() {
        initComposants();
        initPiece(DoConnectionBDD.nIdDem);
        this.setTitle(Outil.TitleApp);
        this.setLocationRelativeTo(null);
        this.setSize(504, 650);
        alimentArea();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonAjoutPiece) {
            ajoutPieceBDD();
        }
        if (e.getSource() == jButtonRetour) {
            Inventaire iv = new Inventaire();
            iv.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == jButtonAjouterCarton) {
            ajouterCartonBDD();
        }
        if (e.getSource() == jButtonSupprimerCarton) {
            supprimerCartonBDD();
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jComboBoxPiece) {
            if (e.getStateChange() == 1) {
                alimentArea();
            }
        }
    }

    private void initComposants() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelTitre = new javax.swing.JLabel();
        jComboBoxPiece = new javax.swing.JComboBox<>();
        jLabelPiece = new javax.swing.JLabel();
        jLabelCarton = new javax.swing.JLabel();
        jComboBoxCarton = new javax.swing.JComboBox<>();
        jButtonAjouterCarton = new javax.swing.JButton();
        jLabelListe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaListe = new javax.swing.JTextArea();
        jLabelQuantite = new javax.swing.JLabel();
        jTextFieldQuantite = new javax.swing.JTextField();
        jButtonRetour = new javax.swing.JButton();
        jButtonSupprimerCarton = new javax.swing.JButton();
        jTextFieldAjoutPiece = new javax.swing.JTextField();
        jButtonAjoutPiece = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 650));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabelTitre.setText("Inventaire des cartons :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 54, 0, 0);
        getContentPane().add(jLabelTitre, gridBagConstraints);

        jComboBoxPiece.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"salon"}));
        jComboBoxPiece.setToolTipText("");
        jComboBoxPiece.addItemListener(this);

        jComboBoxPiece.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 6, 0, 0);
        getContentPane().add(jComboBoxPiece, gridBagConstraints);

        jLabelPiece.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelPiece.setText("Piece :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 15, 0, 0);
        getContentPane().add(jLabelPiece, gridBagConstraints);

        jLabelCarton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelCarton.setText("Carton :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 15, 0, 0);
        getContentPane().add(jLabelCarton, gridBagConstraints);

        jComboBoxCarton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Petit", "Moyen", "Barrel", "Penderie", "Tableau"}));
        jComboBoxCarton.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 6, 0, 0);
        getContentPane().add(jComboBoxCarton, gridBagConstraints);

        jButtonAjouterCarton.setText("Ajouter");
        jButtonAjouterCarton.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 9, 0, 15);
        getContentPane().add(jButtonAjouterCarton, gridBagConstraints);

        jLabelListe.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelListe.setText("Liste des cartons :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 0, 0, 0);
        getContentPane().add(jLabelListe, gridBagConstraints);

        jTextAreaListe.setColumns(20);
        jTextAreaListe.setFont(new java.awt.Font("Monospaced", 0, 17)); // NOI18N
        jTextAreaListe.setRows(5);
        jTextAreaListe.setMinimumSize(new java.awt.Dimension(194, 220));
        jTextAreaListe.setPreferredSize(new java.awt.Dimension(204, 220));
        jScrollPane1.setViewportView(jTextAreaListe);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 32;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 453;
        gridBagConstraints.ipady = 218;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(26, 0, 0, 15);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabelQuantite.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelQuantite.setText("Quantite :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 8, 0, 0);
        getContentPane().add(jLabelQuantite, gridBagConstraints);

        jTextFieldQuantite.setText("50");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 6, 0, 0);
        getContentPane().add(jTextFieldQuantite, gridBagConstraints);

        jButtonRetour.setText("Retour");
        jButtonRetour.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 28, 37, 0);
        getContentPane().add(jButtonRetour, gridBagConstraints);

        jButtonSupprimerCarton.setText("Supprimer");
        jButtonSupprimerCarton.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 0, 15);
        getContentPane().add(jButtonSupprimerCarton, gridBagConstraints);

        jTextFieldAjoutPiece.setText("Garage");
        jTextFieldAjoutPiece.setMinimumSize(new java.awt.Dimension(100, 30));
        jTextFieldAjoutPiece.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 30, 0, 0);
        getContentPane().add(jTextFieldAjoutPiece, gridBagConstraints);

        jButtonAjoutPiece.setText("Ajouter");
        jButtonAjoutPiece.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 18, 0, 0);
        getContentPane().add(jButtonAjoutPiece, gridBagConstraints);

        pack();

    }

    public void ajouterCartonBDD() {

        String taille = jComboBoxCarton.getSelectedItem().toString();
        String piece = jComboBoxPiece.getSelectedItem().toString();
        int quantite = Integer.parseInt(jTextFieldQuantite.getText());
        if (quantite > 0) {
            try {
                String pRequete = "Select quantite, piece, taille from Carton where id_dem=" + DoConnectionBDD.nIdDem + " and  piece='" + piece + "' and taille= '" + taille + "'";
                Statement requete = db.createStatement();
                ResultSet rs = requete.executeQuery(pRequete);

                if (rs.next()) {
                    String sRequete = "Update Carton set quantite=quantite+" + quantite + "  where id_dem=" + DoConnectionBDD.nIdDem + " and  piece='" + piece + "' and taille='" + taille + "'";
                    DoConnectionBDD.DoExecuteSQL(sRequete);
                } else {//System.out.println("dans le insert");
                    String sRequete = "INSERT INTO Carton(id_carton,id_dem,taille,quantite,piece) values(NULL," + DoConnectionBDD.nIdDem + ",'" + taille + "'," + quantite + ",'" + piece + "')";
                    DoConnectionBDD.DoExecuteSQL(sRequete);
                }
                rs.close();
                requete.close();
                alimentArea();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void ajoutPieceBDD() {
        String piece = jTextFieldAjoutPiece.getText();

        String sRequete = "INSERT INTO Piece(champs,valeur_str,valeur_num) values('PIECE','" + piece + "',0)";
        DoConnectionBDD.DoExecuteSQL(sRequete);

        initPiece(DoConnectionBDD.nIdDem);
    }

    public void supprimerCartonBDD() {

        String taille = jComboBoxCarton.getSelectedItem().toString();
        String piece = jComboBoxPiece.getSelectedItem().toString();
        int quantite = Integer.parseInt(jTextFieldQuantite.getText());
        try {
            String pRequete = "Select * from Carton where id_dem=" + DoConnectionBDD.nIdDem + " and  piece='" + piece + "'and  taille='" + taille + "' and quantite=" + quantite;
            Statement srequete = db.createStatement();
            ResultSet rs = srequete.executeQuery(pRequete);

            if (rs.next()) {
                //System.out.println("detect delete a 0");
                String sRequete = "DELETE FROM Carton where id_dem=" + DoConnectionBDD.nIdDem + " and taille='" + taille + "' and piece='" + piece + "' and quantite=" + quantite;

                DoConnectionBDD.DoExecuteSQL(sRequete);

            } else {

                String dRequete = "Update Carton set quantite=quantite-" + quantite + "  where id_dem=" + DoConnectionBDD.nIdDem + " and  piece='" + piece + "' and taille='" + taille + "'and quantite>=" + quantite + "";

                DoConnectionBDD.DoExecuteSQL(dRequete);
            }
            rs.close();
            srequete.close();
            alimentArea();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alimentArea() {

        String piece = jComboBoxPiece.getSelectedItem().toString();

        try {
            String pRequete = "Select quantite, taille from Carton where id_dem=" + DoConnectionBDD.nIdDem + " and  piece='" + piece + "'";
            Statement requete = db.createStatement();
            ResultSet rs = requete.executeQuery(pRequete);
            jTextAreaListe.setText("");
            while (rs.next()) {
                jTextAreaListe.append("- " + rs.getString(1) + " " + rs.getString(2) + " cartons\n");

            }
            rs.close();
            requete.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initPiece(int ID) {
        try {
            String sRequete = "SELECT  valeur_str from Piece where champs='PIECE'";
            //infoBox(sRequete);
            Statement requete = db.createStatement();
            ResultSet rs = null;
            rs = requete.executeQuery(sRequete);

            int i = 1;
            jComboBoxPiece.removeAllItems();
            while (rs.next()) {
                String var = rs.getString(i);
                jComboBoxPiece.addItem(var);
            }
            rs.close();
            requete.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
    }

    private javax.swing.JButton jButtonAjoutPiece;
    private javax.swing.JButton jButtonAjouterCarton;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JButton jButtonSupprimerCarton;
    private javax.swing.JComboBox<String> jComboBoxCarton;
    private javax.swing.JComboBox<String> jComboBoxPiece;
    private javax.swing.JLabel jLabelCarton;
    private javax.swing.JLabel jLabelListe;
    private javax.swing.JLabel jLabelPiece;
    private javax.swing.JLabel jLabelQuantite;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaListe;
    private javax.swing.JTextField jTextFieldAjoutPiece;
    private javax.swing.JTextField jTextFieldQuantite;

}

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

public class Meubles extends javax.swing.JFrame implements ActionListener, ItemListener {

    public static boolean isdemontable = false;
    private int i = 0;

    public Meubles() {

        initComposants();
        this.setTitle(Outil.TitleApp);
        this.setLocationRelativeTo(null);
        initPiece(DoConnectionBDD.nIdDem);
        this.setSize(500, 650);
        jTextFieldMeuble.setText(Outil.meubleDemont);
        if (isdemontable == true) {
            jTextFieldHauteur.setText("");
            jTextFieldLargeur.setText("");
            jTextFieldLongueur.setText("");
            jTextFieldQuantite.setText("");
        }
        alimentArea();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonRetour) {
            Inventaire iv = new Inventaire();
            iv.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == jButtonAjouter) {
            ajoutMeubleBDD();
        }
        if (e.getSource() == jButton1) {
            meubleDemont();
        }
        if (e.getSource() == jButtonDetect) {
            randommeuble();
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

        jButtonDetect = new javax.swing.JButton();
        jTextFieldHauteur = new javax.swing.JTextField();
        jLabelMeuble = new javax.swing.JLabel();
        jTextFieldMeuble = new javax.swing.JTextField();
        jLabelDescri = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescri = new javax.swing.JTextArea();
        jLabelQuantite = new javax.swing.JLabel();
        jTextFieldQuantite = new javax.swing.JTextField();
        jLabelPiece = new javax.swing.JLabel();
        jButtonRetour = new javax.swing.JButton();
        jLabelTitre = new javax.swing.JLabel();
        jButtonAjouter = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaListmeuble = new javax.swing.JTextArea();
        jLabelListmeuble = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldLongueur = new javax.swing.JTextField();
        jTextFieldLargeur = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBoxPiece = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 650));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jButtonDetect.setText("Detecter meuble");
        jButtonDetect.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 29;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 55, 0, 0);
        getContentPane().add(jButtonDetect, gridBagConstraints);

        jTextFieldHauteur.setText("100");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 0, 0);
        getContentPane().add(jTextFieldHauteur, gridBagConstraints);

        jLabelMeuble.setText("Meuble :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 51;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 0, 0, 0);
        getContentPane().add(jLabelMeuble, gridBagConstraints);

        jTextFieldMeuble.setText("chaise");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 133;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 45;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        getContentPane().add(jTextFieldMeuble, gridBagConstraints);

        jLabelDescri.setText("Description :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 26, 0, 0);
        getContentPane().add(jLabelDescri, gridBagConstraints);

        jTextAreaDescri.setColumns(20);
        jTextAreaDescri.setRows(5);
        jTextAreaDescri.setText("\n");
        jScrollPane1.setViewportView(jTextAreaDescri);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 315;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 310;
        gridBagConstraints.ipady = 64;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(29, 1, 0, 33);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabelQuantite.setText("Quantite :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 26, 0, 0);
        getContentPane().add(jLabelQuantite, gridBagConstraints);

        jTextFieldQuantite.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(jTextFieldQuantite, gridBagConstraints);

        jLabelPiece.setText("destination du meuble :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 41, 0, 0);
        getContentPane().add(jLabelPiece, gridBagConstraints);

        jButtonRetour.setText("RETOUR");
        jButtonRetour.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 35, 16, 0);
        getContentPane().add(jButtonRetour, gridBagConstraints);

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabelTitre.setText("Inventaire des meubles :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 310;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 41, 0, 0);
        getContentPane().add(jLabelTitre, gridBagConstraints);

        jButtonAjouter.setText("Ajouter meuble");
        jButtonAjouter.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 91;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 131;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 16, 0, 0);
        getContentPane().add(jButtonAjouter, gridBagConstraints);

        jTextAreaListmeuble.setColumns(20);
        jTextAreaListmeuble.setRows(5);
        jScrollPane2.setViewportView(jTextAreaListmeuble);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 311;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 293;
        gridBagConstraints.ipady = 99;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(22, 4, 0, 33);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jLabelListmeuble.setText("Liste de meubles :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 15, 0, 0);
        getContentPane().add(jLabelListmeuble, gridBagConstraints);

        jLabel1.setText("hauteur :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 26, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("longueur :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 41;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 8, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Largueur :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 133;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 19, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jTextFieldLongueur.setText("50");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 91;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        getContentPane().add(jTextFieldLongueur, gridBagConstraints);

        jTextFieldLargeur.setText("60");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 177;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 132;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        getContentPane().add(jTextFieldLargeur, gridBagConstraints);

        jButton1.setText("Description detaillee");
        jButton1.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 41, 0, 0);
        getContentPane().add(jButton1, gridBagConstraints);

        jComboBoxPiece.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Salon", "Cuisine", "Chambre"}));
        jComboBoxPiece.addItemListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 91;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 43;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 16, 0, 0);
        getContentPane().add(jComboBoxPiece, gridBagConstraints);

        pack();

    }

    public void meubleDemont() {
        isdemontable = true;
        Outil.meubleDemont = jTextFieldMeuble.getText();

        int id = DoConnectionBDD.nIdDem;
        int demont = 1;
        DoConnectionBDD.nIdmeuble = DoConnectionBDD.nextMaxId("Meuble", "id_meuble");
        int idmeuble = DoConnectionBDD.nIdmeuble;

        String nomMeuble = jTextFieldMeuble.getText();
        int hauteur = Integer.parseInt(jTextFieldHauteur.getText());
        int largeur = Integer.parseInt(jTextFieldLargeur.getText());
        int longueur = Integer.parseInt(jTextFieldLongueur.getText());
        int quantite = Integer.parseInt(jTextFieldQuantite.getText());
        String desc = jTextAreaDescri.getText();
        String piece = jComboBoxPiece.getSelectedItem().toString();

        String sRequete = "Insert into Meuble(id_meuble,id_dem, meuble, hauteur, largeur, longueur, quantite, description, demontable,piece)";
        sRequete = sRequete + " values (" + idmeuble + "," + id + ",'" + nomMeuble + "'," + hauteur + "," + largeur + "," + longueur + "," + quantite + ",'" + desc + "'," + demont + ",'" + piece + "')";

        DoConnectionBDD.DoExecuteSQL(sRequete);
        alimentArea();

        MeublesDemontable md = new MeublesDemontable();
        md.setVisible(true);
        this.setVisible(false);
    }

    public void ajoutMeubleBDD() {

        if (validateForm()) {
            int id = DoConnectionBDD.nIdDem;
            int demont = 0;
            DoConnectionBDD.nIdmeuble = DoConnectionBDD.nextMaxId("Meuble", "id_meuble");
            int idmeuble = DoConnectionBDD.nIdmeuble;
            String nomMeuble = jTextFieldMeuble.getText();
            int hauteur = Integer.parseInt(jTextFieldHauteur.getText());
            int largeur = Integer.parseInt(jTextFieldLargeur.getText());
            int longueur = Integer.parseInt(jTextFieldLongueur.getText());
            int quantite = Integer.parseInt(jTextFieldQuantite.getText());
            String desc = jTextAreaDescri.getText();
            String piece = jComboBoxPiece.getSelectedItem().toString();

            String sRequete = "Insert into Meuble(id_meuble,id_dem, meuble, hauteur, largeur, longueur, quantite, description, demontable,piece)";
            sRequete = sRequete + " values (" + idmeuble + "," + id + ",'" + nomMeuble + "'," + hauteur + "," + largeur + "," + longueur + "," + quantite + ",'" + desc + "'," + demont + ",'" + piece + "')";

            DoConnectionBDD.DoExecuteSQL(sRequete);

            alimentArea();
        }

        isdemontable = false;
    }

    public boolean validateForm() {
        if (Outil.isEmpty(jTextFieldMeuble.getText())) {
            Outil.errorBox("Veuillez renseignez le champ meuble");
            return false;
        }
        if (Integer.parseInt(jTextFieldQuantite.getText()) < 1) {
            if (Outil.isEmpty(jTextFieldHauteur.getText()) || Outil.isEmpty(jTextFieldLongueur.getText()) || Outil.isEmpty(jTextFieldLargeur.getText())) {
                Outil.errorBox("Veuillez renseignez tout les champs de hauteur de largueur et de longueur car ce meuble n est pas démontable");
                return false;
            }
        }
        if (Outil.isEmpty(jTextFieldQuantite.getText()) || Integer.parseInt(jTextFieldQuantite.getText()) < 1) {
            Outil.errorBox("Veuillez renseignez le champ quantite d un monter superieur a 1 ");
            return false;
        }

        return true;

    }

    public void randommeuble() {

        if (i == 0) {

            jTextFieldMeuble.setText("Bureau");
            jTextFieldHauteur.setText("130");
            jTextFieldLargeur.setText("80");
            jTextFieldLongueur.setText("190");
            jTextFieldQuantite.setText("1");
            jTextAreaDescri.setText("Bureau de PAPA. Ne pas toucher.");
            i++;
        } else if (i == 1) {
            jTextFieldMeuble.setText("Table");
            jTextFieldHauteur.setText("130");
            jTextFieldLargeur.setText("150");
            jTextFieldLongueur.setText("300");
            jTextFieldQuantite.setText("1");
            jTextAreaDescri.setText("Table a manger");
            i++;
        } else if (i == 2) {
            jTextFieldMeuble.setText("Chaise");
            jTextFieldHauteur.setText("120");
            jTextFieldLargeur.setText("60");
            jTextFieldLongueur.setText("40");
            jTextFieldQuantite.setText("8");
            jTextAreaDescri.setText("chaise pour la table a manger");
            i++;
        } else if (i == 3) {
            jTextFieldMeuble.setText("Blibliotheque");
            jTextFieldHauteur.setText("300");
            jTextFieldLargeur.setText("50");
            jTextFieldLongueur.setText("200");
            jTextFieldQuantite.setText("1");
            jTextAreaDescri.setText("Blibliotheque de la famille");
            i = 0;
        }
    }

    public void initPiece(int ID) {
        try {
            String sRequete = "SELECT  valeur_str from Piece where champs='PIECE'";

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

    public void alimentArea() {

        String piece = jComboBoxPiece.getSelectedItem().toString();

        try {
            String pRequete = "Select quantite, meuble,demontable from Meuble where id_dem=" + DoConnectionBDD.nIdDem + " and  piece='" + piece + "'";
            Statement requete = db.createStatement();
            ResultSet rs = requete.executeQuery(pRequete);
            jTextAreaListmeuble.setText("");
            while (rs.next()) {
                if (rs.getInt(3) == 1) {
                    jTextAreaListmeuble.append("- " + rs.getString(1) + " " + rs.getString(2) + " meubles demontable \n");
                } else {
                    jTextAreaListmeuble.append("- " + rs.getString(1) + " " + rs.getString(2) + " meubles \n");
                }

            }
            rs.close();
            requete.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonDetect;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JComboBox<String> jComboBoxPiece;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDescri;
    private javax.swing.JLabel jLabelListmeuble;
    private javax.swing.JLabel jLabelMeuble;
    private javax.swing.JLabel jLabelPiece;
    private javax.swing.JLabel jLabelQuantite;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaDescri;
    private javax.swing.JTextArea jTextAreaListmeuble;
    private javax.swing.JTextField jTextFieldHauteur;
    private javax.swing.JTextField jTextFieldLargeur;
    private javax.swing.JTextField jTextFieldLongueur;
    private javax.swing.JTextField jTextFieldMeuble;
    private javax.swing.JTextField jTextFieldQuantite;

}

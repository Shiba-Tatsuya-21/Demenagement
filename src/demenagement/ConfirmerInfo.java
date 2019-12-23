package demenagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import demenagement.Outil;
import static demenagement.DoConnectionBDD.db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import demenagement.DoConnectionBDD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class ConfirmerInfo extends javax.swing.JFrame implements ActionListener {

    public ConfirmerInfo() {
        DoConnectionBDD.DoConnectionJDBC();
        //initComponents();
        initComposants();
        initDataForm(DoConnectionBDD.nIdDem);
        this.setTitle(Outil.TitleApp);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(500, 650);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButtonConf) {
            if (confirmation()) {
                Inventaire iv = new Inventaire();
                iv.setVisible(true);
                this.setVisible(false);
            }
        }
    }

    private void initComposants() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelTitre = new javax.swing.JLabel();
        jLabelLieu = new javax.swing.JLabel();
        jLabelAcces = new javax.swing.JLabel();
        jTextFieldLieu = new javax.swing.JTextField();
        jLabelVille = new javax.swing.JLabel();
        jTextFieldVille = new javax.swing.JTextField();
        jTextFieldEtage = new javax.swing.JTextField();
        jTextFieldDistance = new javax.swing.JTextField();
        jLabelEtage = new javax.swing.JLabel();
        jLabelDistance = new javax.swing.JLabel();
        jButtonConf = new javax.swing.JButton();
        jLabelMetres = new javax.swing.JLabel();
        jLabelCodepostal = new javax.swing.JLabel();
        jTextFieldCodepostal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 650));
        setSize(new java.awt.Dimension(500, 650));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabelTitre.setText("Confirmation Informations : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(63, 30, 0, 27);
        getContentPane().add(jLabelTitre, gridBagConstraints);

        jLabelLieu.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabelLieu.setText("Lieu :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 68, 0, 0);
        getContentPane().add(jLabelLieu, gridBagConstraints);

        jLabelAcces.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabelAcces.setText("Acces :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 68, 0, 0);
        getContentPane().add(jLabelAcces, gridBagConstraints);

        jTextFieldLieu.setText("7 rue du saule de la chasse");
        jTextFieldLieu.setPreferredSize(new java.awt.Dimension(200, 26));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 194;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 6, 0, 0);
        getContentPane().add(jTextFieldLieu, gridBagConstraints);

        jLabelVille.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabelVille.setText("Ville :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 68, 0, 0);
        getContentPane().add(jLabelVille, gridBagConstraints);

        jTextFieldVille.setText("Lieusaint");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 194;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 6, 0, 0);
        getContentPane().add(jTextFieldVille, gridBagConstraints);

        jTextFieldEtage.setText("Numero ");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 169;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 6, 0, 0);
        getContentPane().add(jTextFieldEtage, gridBagConstraints);

        jTextFieldDistance.setText("123");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 169;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 6, 0, 0);
        getContentPane().add(jTextFieldDistance, gridBagConstraints);

        jLabelEtage.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabelEtage.setText("Etage :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 91, 0, 0);
        getContentPane().add(jLabelEtage, gridBagConstraints);

        jLabelDistance.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabelDistance.setText("Distance :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 91, 0, 0);
        getContentPane().add(jLabelDistance, gridBagConstraints);

        jButtonConf.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButtonConf.setForeground(new java.awt.Color(255, 0, 0));
        jButtonConf.setText("Confirmer");
        jButtonConf.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(76, 112, 34, 0);
        getContentPane().add(jButtonConf, gridBagConstraints);

        jLabelMetres.setText("KM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 6, 0, 0);
        getContentPane().add(jLabelMetres, gridBagConstraints);

        jLabelCodepostal.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelCodepostal.setText("Code postal :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 68, 0, 0);
        getContentPane().add(jLabelCodepostal, gridBagConstraints);

        jTextFieldCodepostal.setText("77127");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 15, 0, 0);
        getContentPane().add(jTextFieldCodepostal, gridBagConstraints);

        pack();
    }

    public boolean valideFormulaire() {// methode qui verifie que les champs obligatoire soit remplie de numérique ou de string

        if (Outil.isEmpty(jTextFieldLieu.getText())) {// champ vide
            Outil.errorBox("Veuillez renseignez le champ Lieu");
            return false;
        }
        if (jTextFieldCodepostal.getText().length() < 5 || jTextFieldCodepostal.getText().length() > 5 || !Outil.estUnEntier(jTextFieldCodepostal.getText())) {// champ vide
            Outil.errorBox("Veuillez renseignez le champ Code postal avec 5 chiffres");
            return false;
        }
        if (jTextFieldEtage.getText().length() == 0) {// champ vide
            Outil.errorBox("Veuillez renseignez le champ Etage");
            return false;
        }
        if (jTextFieldDistance.getText().length() == 0 || !Outil.estUnEntier(jTextFieldDistance.getText()) || jTextFieldDistance.getText().equals("0")) {// champ vide
            Outil.errorBox("Veuillez renseignez le champ Distance avec un nombre superieur a 0");
            return false;
        }
        if (jTextFieldVille.getText().length() == 0) {// champ vide
            Outil.errorBox("Veuillez renseignez le champ Ville");
            return false;
        }

        return true;
    }

    public void initDataForm(int ID) {
        try {
            if (ID > 0) {
                // System.out.println(ID);
                String sRequete = "SELECT  Lieu, Ville, Etage, Code_postal, Distance from Demenagement where id_dem=" + ID;
                //infoBox(sRequete);
                Statement requete = db.createStatement();
                ResultSet rs = requete.executeQuery(sRequete);
                rs.next();// quand il y aura plusieur ligne de retourne while(re.next())
                jTextFieldLieu.setText(rs.getString(1));
                jTextFieldVille.setText(rs.getString(2));
                jTextFieldEtage.setText(rs.getString(3));
                jTextFieldCodepostal.setText(rs.getString(4));
                jTextFieldDistance.setText(rs.getInt(5) + "");
                rs.close();
                requete.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean confirmation() {

        String Nom = "Pisano";
        String Prenom = "Vincent";
        String Lieu = jTextFieldLieu.getText();
        String Ville = jTextFieldVille.getText();
        String Etage = jTextFieldEtage.getText();
        String CodePostal = jTextFieldCodepostal.getText();
        String Distance = jTextFieldDistance.getText();

        if (valideFormulaire()) {
            if (Outil.ConfirmDialog("Etes-vous sur de vouloir confirmer  ?")) {
                if (DoConnectionBDD.nIdDem == 0) {
                    DoConnectionBDD.nIdDem = DoConnectionBDD.nextMaxId("Demenagement", "id_dem");
                    String sRequete = "Insert into Demenagement(id_dem, Nom, Prenom, Lieu, Ville, Etage, Code_postal, Distance)";
                    sRequete = sRequete + " values (" + DoConnectionBDD.nIdDem + ",'" + Nom + "','" + Prenom + "','" + Lieu + "','" + Ville + "','" + Etage + "','" + CodePostal + "','" + Distance + "')";

                    DoConnectionBDD.DoExecuteSQL(sRequete);
                    return true;
                } else {
                    String sRequete = "Update Demenagement set Nom='" + Nom + "', Prenom= '" + Prenom + "', Lieu='" + Lieu + "', Ville='" + Ville + "', Etage='";
                    sRequete = sRequete + Etage + "', Code_postal='" + CodePostal + "', Distance='" + Distance + "' where id_dem=" + DoConnectionBDD.nIdDem;

                    DoConnectionBDD.DoExecuteSQL(sRequete);
                    return true;
                }

            }
            return false;
        }
        return false;
    }

    public static void main(String args[]) {

    }

    private javax.swing.JButton jButtonConf;
    private javax.swing.JLabel jLabelAcces;
    private javax.swing.JLabel jLabelCodepostal;
    private javax.swing.JLabel jLabelDistance;
    private javax.swing.JLabel jLabelEtage;
    private javax.swing.JLabel jLabelLieu;
    private javax.swing.JLabel jLabelMetres;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JLabel jLabelVille;
    private javax.swing.JTextField jTextFieldCodepostal;
    private javax.swing.JTextField jTextFieldDistance;
    private javax.swing.JTextField jTextFieldEtage;
    private javax.swing.JTextField jTextFieldLieu;
    private javax.swing.JTextField jTextFieldVille;

}

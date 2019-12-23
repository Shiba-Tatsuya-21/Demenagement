package demenagement;

import demenagement.Outil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import demenagement.Meubles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeublesDemontable extends javax.swing.JFrame implements ActionListener {

    private int nbInsert = 0;

    public MeublesDemontable() {

        initComposants();
        this.setTitle(Outil.TitleApp);
        this.setLocationRelativeTo(null);
        this.setSize(500, 650);
        Meubles.isdemontable = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonTerminer) {
            if (nbInsert >= Integer.parseInt(jTextFieldNbElem.getText())) {
                Meubles m = new Meubles();
                m.setVisible(true);
                this.setVisible(false);
            } else {
                Outil.errorBox("Veuillez renseignez toutes les hauteurs, largeurs et longueur de tous les elements");
            }
        }
        if (e.getSource() == jButtonValider) {
            insertElement();
        }
    }

    private void initComposants() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelMeubleDem = new javax.swing.JLabel();
        jLabelNbElem = new javax.swing.JLabel();
        jTextFieldNbElem = new javax.swing.JTextField();
        jLabelVolparelem = new javax.swing.JLabel();
        jLabelNumElem = new javax.swing.JLabel();
        jTextFieldNumElem = new javax.swing.JTextField();
        jLabelVolElem = new javax.swing.JLabel();
        jButtonValider = new javax.swing.JButton();
        jButtonTerminer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldHauteur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldLongueur = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldLargeur = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 650));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelMeubleDem.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabelMeubleDem.setText("Meuble Demontable :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 70, 0, 0);
        getContentPane().add(jLabelMeubleDem, gridBagConstraints);

        jLabelNbElem.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelNbElem.setText("Nombre  elements :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(77, 70, 0, 0);
        getContentPane().add(jLabelNbElem, gridBagConstraints);

        jTextFieldNbElem.setText("7");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(76, 18, 0, 0);
        getContentPane().add(jTextFieldNbElem, gridBagConstraints);

        jLabelVolparelem.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelVolparelem.setText("Volume par element :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 70, 0, 0);
        getContentPane().add(jLabelVolparelem, gridBagConstraints);

        jLabelNumElem.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelNumElem.setText("element numero :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 108, 0, 0);
        getContentPane().add(jLabelNumElem, gridBagConstraints);

        jTextFieldNumElem.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 7, 0, 0);
        getContentPane().add(jTextFieldNumElem, gridBagConstraints);

        jLabelVolElem.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelVolElem.setText("Volume :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 108, 0, 0);
        getContentPane().add(jLabelVolElem, gridBagConstraints);

        jButtonValider.setText("Valider volume");
        jButtonValider.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 16, 0, 0);
        getContentPane().add(jButtonValider, gridBagConstraints);

        jButtonTerminer.setText("Terminer meuble");
        jButtonTerminer.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 18, 41, 39);
        getContentPane().add(jButtonTerminer, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("hauteur :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 9, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jTextFieldHauteur.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        getContentPane().add(jTextFieldHauteur, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("longueur :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 9, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jTextFieldLongueur.setText("40");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 6, 0, 0);
        getContentPane().add(jTextFieldLongueur, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Largeur :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 9, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jTextFieldLargeur.setText("20");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 5, 0, 0);
        getContentPane().add(jTextFieldLargeur, gridBagConstraints);

        pack();

    }

    public void insertElement() {
        if (validateForm()) {
            int id = DoConnectionBDD.nIdDem;
            int numElem = Integer.parseInt(jTextFieldNumElem.getText());
            int hauteur = Integer.parseInt(jTextFieldHauteur.getText());
            int largeur = Integer.parseInt(jTextFieldLargeur.getText());
            int longueur = Integer.parseInt(jTextFieldLongueur.getText());

            String sRequete = "Insert into Meuble_demont(id_meuble,id_dem, num_elem, hauteur, largeur, longueur)";
            sRequete = sRequete + " values (" + DoConnectionBDD.nIdmeuble + "," + id + "," + numElem + "," + hauteur + "," + largeur + "," + longueur + ")";
            nbInsert++;
            DoConnectionBDD.DoExecuteSQL(sRequete);

        }
    }

    public boolean validateForm() {
        if (Outil.isEmpty(jTextFieldNbElem.getText())) {
            Outil.errorBox("Veuillez renseignez le champ nombre element");
            return false;
        }
        if (Outil.isEmpty(jTextFieldNumElem.getText())) {
            Outil.errorBox("Veuillez renseignez le champ numero element");
            return false;
        }
        if (Outil.isEmpty(jTextFieldHauteur.getText()) || Outil.isEmpty(jTextFieldLargeur.getText()) || Outil.isEmpty(jTextFieldLongueur.getText())) {
            Outil.errorBox("Veuillez renseignez tous les champ de hauteur, largeur et longueur ");
            return false;
        }
        if (Integer.parseInt(jTextFieldNumElem.getText()) < 1 || Integer.parseInt(jTextFieldNumElem.getText()) > Integer.parseInt(jTextFieldNbElem.getText())) {
            Outil.errorBox("Veuillez renseignez toutes les hauteur, largueur et longueur de tous les nombre  elements ");
            return false;
        }

        return true;
    }

    public static void main(String args[]) {

    }

    private javax.swing.JButton jButtonTerminer;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelMeubleDem;
    private javax.swing.JLabel jLabelNbElem;
    private javax.swing.JLabel jLabelNumElem;
    private javax.swing.JLabel jLabelVolElem;
    private javax.swing.JLabel jLabelVolparelem;
    private javax.swing.JTextField jTextFieldHauteur;
    private javax.swing.JTextField jTextFieldLargeur;
    private javax.swing.JTextField jTextFieldLongueur;
    private javax.swing.JTextField jTextFieldNbElem;
    private javax.swing.JTextField jTextFieldNumElem;

}

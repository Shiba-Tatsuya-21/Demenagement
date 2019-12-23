package demenagement;

import java.awt.Color;
import demenagement.Outil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventaire extends javax.swing.JFrame implements ActionListener {

    public Inventaire() {

        initComposants();
        this.setTitle(Outil.TitleApp);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButtonRetour) {
            ConfirmerInfo ci = new ConfirmerInfo();
            this.setVisible(false);
            ci.setVisible(true);
            dispose();
        } else if (e.getSource() == jButtonCartons) {
            Cartons cs = new Cartons();
            cs.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == jButtonMeubles) {
            Meubles ms = new Meubles();
            ms.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == jButtonSuivant) {
            OptionBudget ob = new OptionBudget();
            ob.setVisible(true);
            this.setVisible(false);
        }
    }

    private void initComposants() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelTitre = new javax.swing.JLabel();
        jButtonCartons = new javax.swing.JButton();
        jButtonMeubles = new javax.swing.JButton();
        jButtonSuivant = new javax.swing.JButton();
        jButtonRetour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 650));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabelTitre.setText("Realisation de l'inventaire :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 24, 0, 0);
        getContentPane().add(jLabelTitre, gridBagConstraints);

        jButtonCartons.setBackground(new java.awt.Color(0, 204, 0));
        jButtonCartons.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jButtonCartons.setText("CARTONS");
        jButtonCartons.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 61;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(146, 79, 0, 0);
        getContentPane().add(jButtonCartons, gridBagConstraints);

        jButtonMeubles.setBackground(new java.awt.Color(0, 0, 255));
        jButtonMeubles.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jButtonMeubles.setText("MEUBLES");
        jButtonMeubles.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 61;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(146, 35, 0, 0);
        getContentPane().add(jButtonMeubles, gridBagConstraints);

        jButtonSuivant.setBackground(new java.awt.Color(255, 204, 51));
        jButtonSuivant.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jButtonSuivant.setText("FINALISER");
        jButtonSuivant.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(178, 85, 0, 15);
        getContentPane().add(jButtonSuivant, gridBagConstraints);

        jButtonRetour.setText("RETOUR");
        jButtonRetour.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(182, 15, 80, 0);
        getContentPane().add(jButtonRetour, gridBagConstraints);

        pack();
    }

    public static void main(String args[]) {

    }

    private javax.swing.JButton jButtonCartons;
    private javax.swing.JButton jButtonMeubles;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JButton jButtonSuivant;
    private javax.swing.JLabel jLabelTitre;

}

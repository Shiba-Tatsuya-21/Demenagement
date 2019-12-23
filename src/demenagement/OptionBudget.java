package demenagement;

import demenagement.Outil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OptionBudget extends javax.swing.JFrame implements ActionListener {

    public OptionBudget() {

        initComposants();
        this.setTitle(Outil.TitleApp);
        this.setLocationRelativeTo(null);
        this.setSize(500, 650);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonEnd) {
            LastInsert();
        }
        if (e.getSource() == jButtonRetour) {
            Inventaire iv = new Inventaire();
            iv.setVisible(true);
            this.setVisible(false);
        }
    }

    private void initComposants() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBudget = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonPlanPre = new javax.swing.JRadioButton();
        jRadioButtonDemPre = new javax.swing.JRadioButton();
        jRadioButtonMisCartPre = new javax.swing.JRadioButton();
        jRadioButtonNettPre = new javax.swing.JRadioButton();
        jRadioButtonEtatSortPre = new javax.swing.JRadioButton();
        jRadioButtonEtatEntPre = new javax.swing.JRadioButton();
        jRadioButtonDateFlexEco = new javax.swing.JRadioButton();
        jRadioButtonGroupEco = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonEnd = new javax.swing.JButton();
        jButtonRetour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 650));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setText("Services Optionnel :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 94, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Budget previsionnel :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 94, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jTextFieldBudget.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldBudget.setText("5000");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 52;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 138;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 7, 0, 0);
        getContentPane().add(jTextFieldBudget, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel3.setText("Services  Premium :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 15, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jRadioButtonPlanPre.setText("Plan Premium");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 91, 0, 0);
        getContentPane().add(jRadioButtonPlanPre, gridBagConstraints);

        jRadioButtonDemPre.setText("Demontage / Remontage Premium");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 91, 0, 0);
        getContentPane().add(jRadioButtonDemPre, gridBagConstraints);

        jRadioButtonMisCartPre.setText("Mise en carton Premium");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 91, 0, 0);
        getContentPane().add(jRadioButtonMisCartPre, gridBagConstraints);

        jRadioButtonNettPre.setText("Nettoyage Premium");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 91, 0, 0);
        getContentPane().add(jRadioButtonNettPre, gridBagConstraints);

        jRadioButtonEtatSortPre.setText("Etat lieu sortie Premium");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 91, 0, 0);
        getContentPane().add(jRadioButtonEtatSortPre, gridBagConstraints);

        jRadioButtonEtatEntPre.setText("Etat lieu entree Premium");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 91, 0, 0);
        getContentPane().add(jRadioButtonEtatEntPre, gridBagConstraints);

        jRadioButtonDateFlexEco.setText("Date flexible Eco");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 85, 0, 0);
        getContentPane().add(jRadioButtonDateFlexEco, gridBagConstraints);

        jRadioButtonGroupEco.setText("Groupage Eco");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 85, 0, 0);
        getContentPane().add(jRadioButtonGroupEco, gridBagConstraints);

        jRadioButton9.setText("Client demonte meuble Eco");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 85, 0, 0);
        getContentPane().add(jRadioButton9, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel4.setText("Services  Eco :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 15, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jButtonEnd.setBackground(new java.awt.Color(0, 153, 0));
        jButtonEnd.setText("TERMINER");
        jButtonEnd.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 41, 16, 38);
        getContentPane().add(jButtonEnd, gridBagConstraints);

        jButtonRetour.setText("RETOUR");
        jButtonRetour.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 15, 16, 0);
        getContentPane().add(jButtonRetour, gridBagConstraints);

        pack();

    }

    public void LastInsert() {
        int tab[] = new int[9];
        if (Integer.parseInt(jTextFieldBudget.getText()) > 1000 && jTextFieldBudget.getText() != null) {
            if (jRadioButtonPlanPre.isSelected()) {
                tab[0] = 1;
            }
            if (jRadioButtonDemPre.isSelected()) {
                tab[1] = 1;
            }
            if (jRadioButtonMisCartPre.isSelected()) {
                tab[2] = 1;
            }
            if (jRadioButtonNettPre.isSelected()) {
                tab[3] = 1;
            }
            if (jRadioButtonEtatSortPre.isSelected()) {
                tab[4] = 1;
            }
            if (jRadioButtonEtatEntPre.isSelected()) {
                tab[5] = 1;
            }
            if (jRadioButtonDateFlexEco.isSelected()) {
                tab[6] = 1;
            }
            if (jRadioButtonGroupEco.isSelected()) {
                tab[7] = 1;
            }
            if (jRadioButton9.isSelected()) {
                tab[8] = 1;
            }

            int id = DoConnectionBDD.nIdDem;
            int bud = Integer.parseInt(jTextFieldBudget.getText());
            String sRequete = "Insert into Budget(id_dem, budget, plan_pre, demrem_pre, miscart_pre,nett_pre,etatsort_pre,etatentr_pre,dateflex_eco,group_eco,clientdem_eco)";
            sRequete = sRequete + " values (" + id + "," + bud + "," + tab[0] + "," + tab[1] + "," + tab[2] + "," + tab[3] + "," + tab[4] + "," + tab[5] + "," + tab[6] + "," + tab[7] + "," + tab[8] + ")";

            DoConnectionBDD.DoExecuteSQL(sRequete);

            System.exit(0);
            try {

                DoConnectionBDD.db.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());//renvoie un string 

            }

        } else {
            Outil.errorBox("Veuillez entree un budget superieur ou égal a 1000 euros !");
        }

    }

    public static void main(String args[]) {

    }

    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButton jRadioButtonDateFlexEco;
    private javax.swing.JRadioButton jRadioButtonDemPre;
    private javax.swing.JRadioButton jRadioButtonEtatEntPre;
    private javax.swing.JRadioButton jRadioButtonEtatSortPre;
    private javax.swing.JRadioButton jRadioButtonGroupEco;
    private javax.swing.JRadioButton jRadioButtonMisCartPre;
    private javax.swing.JRadioButton jRadioButtonNettPre;
    private javax.swing.JRadioButton jRadioButtonPlanPre;
    private javax.swing.JTextField jTextFieldBudget;

}

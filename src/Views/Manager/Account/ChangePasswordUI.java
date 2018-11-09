/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Manager.Account;

import Controllers.UserController;
import Section.DesignSection;

/**
 *
 * @author Eunar B. Dayangco
 */
public class ChangePasswordUI extends javax.swing.JFrame {

    /**
     * Creates new form ChangePasswordUI
     */
    private EditAccountUI editAccountUI;
    private UserController controller;
    
    public ChangePasswordUI() {
        initComponents();
        new DesignSection().designForm(this, mainPanel, "mini");
    }
    
    public ChangePasswordUI(EditAccountUI editAccountUI) {
        initComponents();
        new DesignSection().designForm(this, mainPanel, "mini");
        this.editAccountUI = editAccountUI;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRetypePassword = new javax.swing.JPasswordField();
        txtCurrentPassword = new javax.swing.JPasswordField();
        txtnewPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(163, 165, 153));
        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(251, 205, 75));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CHANGE PASSWORD");
        mainPanel.add(jLabel5);
        jLabel5.setBounds(50, 20, 240, 30);

        savebtn.setBackground(new java.awt.Color(251, 205, 75));
        savebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        savebtn.setText("SAVE");
        savebtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        mainPanel.add(savebtn);
        savebtn.setBounds(50, 300, 100, 40);

        cancelbtn.setBackground(new java.awt.Color(251, 205, 75));
        cancelbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelbtn.setText("CANCEL");
        cancelbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });
        mainPanel.add(cancelbtn);
        cancelbtn.setBounds(200, 300, 90, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("New Password:");
        mainPanel.add(jLabel6);
        jLabel6.setBounds(50, 140, 120, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Retype Password:");
        mainPanel.add(jLabel13);
        jLabel13.setBounds(50, 210, 160, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Current Password:");
        mainPanel.add(jLabel11);
        jLabel11.setBounds(50, 70, 160, 30);

        txtRetypePassword.setBackground(new java.awt.Color(251, 205, 75));
        txtRetypePassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRetypePassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRetypePassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtRetypePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRetypePasswordActionPerformed(evt);
            }
        });
        mainPanel.add(txtRetypePassword);
        txtRetypePassword.setBounds(50, 240, 240, 30);

        txtCurrentPassword.setBackground(new java.awt.Color(251, 205, 75));
        txtCurrentPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCurrentPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCurrentPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(txtCurrentPassword);
        txtCurrentPassword.setBounds(50, 100, 240, 30);

        txtnewPassword.setBackground(new java.awt.Color(251, 205, 75));
        txtnewPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnewPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnewPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(txtnewPassword);
        txtnewPassword.setBounds(50, 170, 240, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRetypePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRetypePasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRetypePasswordActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        
       this.controller = new UserController(editAccountUI.getEditedUser());
        
       this.controller.changePasswordProcess(this);
      
        
    }//GEN-LAST:event_savebtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePasswordUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton savebtn;
    private javax.swing.JPasswordField txtCurrentPassword;
    private javax.swing.JPasswordField txtRetypePassword;
    private javax.swing.JPasswordField txtnewPassword;
    // End of variables declaration//GEN-END:variables

    public String getCurrentPassword(){
        return txtCurrentPassword.getText();
    }
    public String getNewPassword(){
        return txtnewPassword.getText();
    }
    public String getRetypePassword(){
        return txtRetypePassword.getText();
    }
}
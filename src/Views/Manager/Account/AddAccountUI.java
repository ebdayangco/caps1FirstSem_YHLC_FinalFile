/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Manager.Account;

import Controllers.UserController;
import static Controllers.UserController.getUserDisplayTable;
import Helpers.TableDesigner;
import Models.User;
import Section.AnimationSection;
import Section.CreateSection;
import Section.DesignSection;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Eunar B. Dayangco
 */
public class AddAccountUI extends javax.swing.JFrame {

    /**
     * Creates new form AddAccountUI
     */
    private UserController controller;
    private ManagerAccountUI managerAccountUI;
    private String message;
    public AddAccountUI() {
        initComponents();
        init();
    }
    public AddAccountUI(ManagerAccountUI managerAccountUI) {
        initComponents();
        init();
        this.managerAccountUI = managerAccountUI;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        fullname_comp = new javax.swing.JTextField();
        email_comp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        contactNumber_comp = new javax.swing.JTextField();
        username_comp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        type_comp = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        closebtn = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        password_comp = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        mainPanel.setBackground(new java.awt.Color(251, 205, 75));
        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setLayout(null);

        fullname_comp.setBackground(new java.awt.Color(163, 165, 153));
        fullname_comp.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        fullname_comp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fullname_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(fullname_comp);
        fullname_comp.setBounds(110, 90, 240, 30);

        email_comp.setBackground(new java.awt.Color(163, 165, 153));
        email_comp.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        email_comp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(email_comp);
        email_comp.setBounds(110, 140, 240, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Email:");
        mainPanel.add(jLabel2);
        jLabel2.setBounds(30, 140, 70, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Contact #:");
        mainPanel.add(jLabel3);
        jLabel3.setBounds(20, 190, 80, 30);

        contactNumber_comp.setBackground(new java.awt.Color(163, 165, 153));
        contactNumber_comp.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        contactNumber_comp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contactNumber_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(contactNumber_comp);
        contactNumber_comp.setBounds(110, 190, 240, 30);

        username_comp.setBackground(new java.awt.Color(163, 165, 153));
        username_comp.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        username_comp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(username_comp);
        username_comp.setBounds(110, 290, 240, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Username:");
        mainPanel.add(jLabel4);
        jLabel4.setBounds(20, 290, 80, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Type:");
        mainPanel.add(jLabel6);
        jLabel6.setBounds(20, 240, 80, 30);

        type_comp.setBackground(new java.awt.Color(163, 165, 153));
        type_comp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        type_comp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Cashier", "Viewer" }));
        type_comp.setToolTipText("");
        mainPanel.add(type_comp);
        type_comp.setBounds(110, 240, 240, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Fullname:");
        mainPanel.add(jLabel7);
        jLabel7.setBounds(40, 90, 70, 17);

        jPanel1.setBackground(new java.awt.Color(163, 165, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        closebtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Galleries/xbutton.png"))); // NOI18N
        closebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closebtnMouseClicked(evt);
            }
        });
        jPanel1.add(closebtn);
        closebtn.setBounds(350, 0, 40, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("CREATE ACCOUNT");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 10, 160, 20);

        mainPanel.add(jPanel1);
        jPanel1.setBounds(0, 0, 390, 40);

        savebtn.setBackground(new java.awt.Color(251, 205, 75));
        savebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        savebtn.setText("CREATE");
        savebtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        savebtn.setFocusPainted(false);
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        mainPanel.add(savebtn);
        savebtn.setBounds(110, 410, 240, 40);

        password_comp.setBackground(new java.awt.Color(163, 165, 153));
        password_comp.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        password_comp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(password_comp);
        password_comp.setBounds(110, 350, 240, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Password:");
        mainPanel.add(jLabel5);
        jLabel5.setBounds(20, 350, 80, 30);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 390, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtnMouseClicked
        goExit();
    }//GEN-LAST:event_closebtnMouseClicked

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        
       this.controller.insertProcess(this);
       
        
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
            java.util.logging.Logger.getLogger(AddAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAccountUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closebtn;
    private javax.swing.JTextField contactNumber_comp;
    private javax.swing.JTextField email_comp;
    private javax.swing.JTextField fullname_comp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField password_comp;
    private javax.swing.JButton savebtn;
    private javax.swing.JComboBox<String> type_comp;
    private javax.swing.JTextField username_comp;
    // End of variables declaration//GEN-END:variables

    public void init(){
       
        this.setBackground(new Color(0,0,0,0));
        this.controller = new UserController();
        new DesignSection().designForm(this, mainPanel, "mini");  
    }
 
    public User getNewUserEntry(){
        
        User user = new User();
        
            user.setFullname(fullname_comp.getText());
            user.setEmail(email_comp.getText());
            user.setContactNumber(contactNumber_comp.getText());
            user.setUserType(type_comp.getSelectedItem().toString());
            user.setUsername(username_comp.getText());
            user.setPassword(password_comp.getText());
            user.setActive(true);
            user.setAddedDate(CreateSection.getDateToday());
        
        return user;
        
    }
     public void clearAll(){
        
         fullname_comp.setText("");
         email_comp.setText("");
         contactNumber_comp.setText("");
         type_comp.setSelectedIndex(0);
         username_comp.setText("");
         password_comp.setText("");
    
    }
     
    public void goExit(){
        new AnimationSection().framesMoveBacktoTop(this, 70, 20);
    }
     
    public boolean validateInput(){
        
        User user = getNewUserEntry();
        
        String createMessage = "";
           
           String fullname = user.getFullname();
           String email = user.getEmail();
           String contactNum = user.getContactNumber();
           String type = user.getUserType();
           String username = user.getUsername();
           String password = user.getPassword();
           
           if(fullname.isEmpty()){createMessage+="Fullname is empty.\n";}
           if(contactNum.isEmpty()){createMessage+="contact number is empty.\n";}
           if(email.isEmpty()){createMessage+="Email is empty.\n";}
           if(type.isEmpty()){createMessage+="Type has no selection.\n";}
           if(username.isEmpty()){createMessage+="Username is empty.\n";}
           if(password.isEmpty()){createMessage+="Password is empty.\n";}
           
           setMessage(createMessage);
           
           return fullname.isEmpty() || email.isEmpty() || contactNum.isEmpty()
                   || type.isEmpty() || username.isEmpty() || password.isEmpty();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
 
    
    

}

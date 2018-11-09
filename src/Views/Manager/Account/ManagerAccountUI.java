/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Manager.Account;


import Controllers.UserController;
import Models.User;
import Section.AnimationSection;
import Section.CreateSection;
import Section.DesignSection;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Eunar B. Dayangco
 */
public class ManagerAccountUI extends javax.swing.JFrame {

    /**
     * Creates new form ManagerAccountUI
     */
    
    private UserController controller;
    private EditAccountUI editAccount;
    private AddAccountUI addAccount;
    
    public ManagerAccountUI() {
        initComponents();
        manualInit();
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userListScrollpane = new javax.swing.JScrollPane();
        userListTable = new javax.swing.JTable();
        editbtn = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        activateDeactivatebtn = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setOpaque(false);

        userListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Name", "Active", "UserID", "Username", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userListScrollpane.setViewportView(userListTable);
        if (userListTable.getColumnModel().getColumnCount() > 0) {
            userListTable.getColumnModel().getColumn(0).setResizable(false);
            userListTable.getColumnModel().getColumn(1).setResizable(false);
            userListTable.getColumnModel().getColumn(2).setResizable(false);
            userListTable.getColumnModel().getColumn(3).setResizable(false);
            userListTable.getColumnModel().getColumn(4).setResizable(false);
            userListTable.getColumnModel().getColumn(5).setResizable(false);
        }

        editbtn.setBackground(new java.awt.Color(102, 0, 0));
        editbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editbtn.setForeground(new java.awt.Color(255, 255, 255));
        editbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Galleries/Manager/edit.png"))); // NOI18N
        editbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editbtn.setFocusPainted(false);
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(204, 153, 0));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton8.setBackground(new java.awt.Color(102, 0, 0));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Galleries/magnifier.png"))); // NOI18N
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setFocusPainted(false);

        jComboBox4.setBackground(new java.awt.Color(102, 0, 0));
        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SHOW MANAGERS", "SHOW CASHIERS", "SHOW VIEWERS" }));
        jComboBox4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton9.setBackground(new java.awt.Color(102, 0, 0));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("SHOW INFO");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setFocusPainted(false);

        jComboBox2.setBackground(new java.awt.Color(102, 0, 0));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SHOW ALL", "SHOW ACTIVE", "SHOW NOT ACTIVE" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        activateDeactivatebtn.setBackground(new java.awt.Color(102, 0, 0));
        activateDeactivatebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        activateDeactivatebtn.setForeground(new java.awt.Color(255, 255, 255));
        activateDeactivatebtn.setText("DEACTIVATE");
        activateDeactivatebtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        activateDeactivatebtn.setFocusPainted(false);
        activateDeactivatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activateDeactivatebtnActionPerformed(evt);
            }
        });

        addbtn.setBackground(new java.awt.Color(102, 0, 0));
        addbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addbtn.setForeground(new java.awt.Color(255, 255, 255));
        addbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Galleries/add.png"))); // NOI18N
        addbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addbtn.setFocusPainted(false);
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(userListScrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(activateDeactivatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(userListScrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activateDeactivatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
       
        if(userListTable.getSelectionModel().isSelectionEmpty()){
            CreateSection.displayInfoMessage("Edit Instruction", 
                    "Please select a row first in the table and Click me again!");
            
        }else{
            int row = userListTable.getSelectedRow();
            User user = this.controller.getUser(Integer.parseInt(userListTable.getValueAt(row,3).toString()));
            this.editAccount = new EditAccountUI(user);
            new AnimationSection().framesMovetoBottom(this.editAccount, 70, 20);
        
        }

    }//GEN-LAST:event_editbtnActionPerformed

    private void activateDeactivatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activateDeactivatebtnActionPerformed
       
         if(userListTable.getSelectionModel().isSelectionEmpty()){
            CreateSection.displayInfoMessage("Edit Instruction", 
                    "Please select a row first in the table and Click me again!");
            
        }else{
           
           int row = userListTable.getSelectedRow(); 
           User user = this.controller.getUser(Integer.parseInt(userListTable.getValueAt(row,3).toString()));
           String activeValue = userListTable.getValueAt(row, 2).toString();
           boolean active_val = activeValue.equals("YES");
           user.setActive(!active_val);
           
           this.controller = new UserController(user);
           this.controller.changeUserAccess();
           
           
         }
        

       
    }//GEN-LAST:event_activateDeactivatebtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        new AnimationSection().framesMovetoBottom(this.addAccount, 70, 20);
    }//GEN-LAST:event_addbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerAccountUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerAccountUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activateDeactivatebtn;
    private javax.swing.JButton addbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JScrollPane userListScrollpane;
    private javax.swing.JTable userListTable;
    // End of variables declaration//GEN-END:variables
       
    public void manualInit(){
        this.setBackground(new Color(0,0,0,0));
        new DesignSection().designTable(userListTable, userListScrollpane);
        this.controller = new UserController();
       
        
        UserController.setUserDisplayTable(userListTable);
        this.controller.displayUserTable();
        this.editAccount = new EditAccountUI();
        this.addAccount = new AddAccountUI(this);
        
        userListTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                if(!userListTable.getSelectionModel().isSelectionEmpty()){
                    int row = userListTable.getSelectedRow();
                    toogleActiveButton(userListTable.getValueAt(row, 2).toString());
                }
               
            }
        });
      
    }

    
   
     
     public JTable getTable(){
         return userListTable;
     }
    
     public void toogleActiveButton(String val){
          
      if(val.equals("YES")){
            activateDeactivatebtn.setText("DEACTIVATE");
      }else{
          activateDeactivatebtn.setText("ACTIVATE");
      }
     
     }

     
    
    
    /********************SEQUENCE OF PROCESSING*********************************
     * 
     * 1. First will create User with content getting from textField - CreateModel methods
     * 2. calling the controller method which is validateInput to sure that value is not empty
     * 3. calling the controller method which is insertProcess
     * 4. If the controller is sending a success call, calling the clearComponents
     * 
    
    */
     
     /*********USER TABLE**********
      * The Table of this class must be putted into the controller. The purpose of this
      * is if any changes happen, the controller will eventually change the data inside 
      * on the table as well, thats why we create static jTable variable in UserController
      
      */
     
     /**************EDIT ACCOUNT************
      * Edit Account is first initialized during this form is open. The edit Account has 
      * getter and setter inside as well as displayInfo. When EditAccoount is initialized,
      * we can access its getter and setter as well as displayInfo. For example, EditAccount is
      * initialized, and then when clicked the save button, This form will get the User Information by
      * calling the CreateUserModel then passed it into the initialized EditAccount like
      * editAccount.setUser then editAccount.displayInfo. In other words, the User info is already
      * there in the editAccount and display already to its components before it open. 
      */
     
     
      
     
     
    
}

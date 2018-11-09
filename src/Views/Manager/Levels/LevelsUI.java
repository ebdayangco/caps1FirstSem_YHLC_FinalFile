/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Manager.Levels;

import Controllers.LevelController;
import Models.Levels;
import Section.AnimationSection;
import Section.CreateSection;
import Section.DesignSection;
import Views.Manager.GeneralPayments.AddGeneralPayment;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eunar B. Dayangco
 */
public class LevelsUI extends javax.swing.JFrame {

    /**
     * Creates new form Levels
     */
    private LevelController controller;
    private Levels selectedLevel;
    private AddGeneralPayment addGeneralPayment;
    
    public LevelsUI() {
        initComponents();
        init();
    }
    
    public LevelsUI(AddGeneralPayment addGeneralPayment) {
        initComponents();
        init();
        this.addGeneralPayment = addGeneralPayment;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        level_comp = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
        levelscrollpane = new javax.swing.JScrollPane();
        levelTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        closebtn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        editbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        mainPanel.setBackground(new java.awt.Color(255, 153, 51));
        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setLayout(null);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Name:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 20, 50, 40);

        level_comp.setBackground(new java.awt.Color(254, 175, 57));
        level_comp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        level_comp.setForeground(new java.awt.Color(0, 0, 0));
        level_comp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        level_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(level_comp);
        level_comp.setBounds(60, 20, 270, 40);

        addbtn.setBackground(new java.awt.Color(254, 175, 57));
        addbtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addbtn.setForeground(new java.awt.Color(0, 0, 0));
        addbtn.setText("ADD");
        addbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel2.add(addbtn);
        addbtn.setBounds(330, 20, 120, 40);

        mainPanel.add(jPanel2);
        jPanel2.setBounds(40, 50, 460, 70);

        levelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        levelscrollpane.setViewportView(levelTable);
        if (levelTable.getColumnModel().getColumnCount() > 0) {
            levelTable.getColumnModel().getColumn(0).setResizable(false);
            levelTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            levelTable.getColumnModel().getColumn(1).setResizable(false);
            levelTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        mainPanel.add(levelscrollpane);
        levelscrollpane.setBounds(40, 130, 450, 230);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        closebtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Galleries/xbutton.png"))); // NOI18N
        closebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closebtnMouseClicked(evt);
            }
        });
        jPanel3.add(closebtn);
        closebtn.setBounds(500, 0, 40, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ADD LEVEL");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 10, 140, 20);

        mainPanel.add(jPanel3);
        jPanel3.setBounds(0, 0, 540, 40);

        editbtn.setBackground(new java.awt.Color(254, 175, 57));
        editbtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        editbtn.setForeground(new java.awt.Color(0, 0, 0));
        editbtn.setText("EDIT");
        editbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });
        mainPanel.add(editbtn);
        editbtn.setBounds(40, 380, 120, 40);

        deletebtn.setBackground(new java.awt.Color(254, 175, 57));
        deletebtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(0, 0, 0));
        deletebtn.setText("DELETE");
        deletebtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        mainPanel.add(deletebtn);
        deletebtn.setBounds(370, 380, 120, 40);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 540, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtnMouseClicked
        new AnimationSection().framesMoveBacktoTop(this, 70, 20);
    }//GEN-LAST:event_closebtnMouseClicked

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        String label = addbtn.getText();
    
        if(label.equals("ADD")){
            this.controller.insertLevel(this);
        }else{
            addbtn.setText("ADD");
            this.controller.updateLevel(this);
        }
      
      
    }//GEN-LAST:event_addbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
       
        if(!levelTable.getSelectionModel().isSelectionEmpty()){
            level_comp.setText(getSelectedLevel().getLevelName());
            addbtn.setText("SAVE");
        }
        else{
            CreateSection.displayInfoMessage("Table Selection", "Please select a row first on the table.");
        }
    }//GEN-LAST:event_editbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        
        if(!levelTable.getSelectionModel().isSelectionEmpty()){
           this.controller.deleteLevel(this);
        }
        else{
            CreateSection.displayInfoMessage("Table Selection", "Please select a row first on the table.");
        }
    }//GEN-LAST:event_deletebtnActionPerformed

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
            java.util.logging.Logger.getLogger(LevelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LevelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LevelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LevelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LevelsUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JLabel closebtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable levelTable;
    private javax.swing.JTextField level_comp;
    private javax.swing.JScrollPane levelscrollpane;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

    public void init(){
        new DesignSection().designForm(this, mainPanel, "mini");
        new DesignSection().designTable(levelTable, levelscrollpane);
        this.controller = new LevelController();
        this.selectedLevel = new Levels();
        
        displayOnTable();
    }

    public Levels getSelectedLevel() {
        
        int row = levelTable.getSelectedRow();
                    Levels selected = new Levels();
                    selected.setLevelID(Integer.parseInt(levelTable.getValueAt(row, 0).toString()));
                    selected.setLevelName(levelTable.getValueAt(row, 1).toString());
     
        return selected;
    }

    public void setSelectedLevel(Levels selectedLevel) {
        
        
        this.selectedLevel = selectedLevel;
    }
    
    
    
    public void displayOnTable(){
        
        DefaultTableModel model = (DefaultTableModel) levelTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[2];
        
        for(Levels level:this.controller.getAllLevels()){
            row[0] = level.getLevelID();
            row[1] = level.getLevelName();
            model.addRow(row);
        }
        
    
    }
    
    public Levels getLevelsEntry(){
        String levelValue = level_comp.getText();
        Levels level = new Levels();
        level.setLevelName(levelValue);
        
        return level;
    }
    
    public Levels getEditedLevel(){
        
        Levels level = getSelectedLevel();
     
        level.setLevelName(level_comp.getText());
        
        return level;
    
    }
    public void clearAll(){
       level_comp.setText("");
    }

    public AddGeneralPayment getAddGeneralPayment() {
        return addGeneralPayment;
    }
    
    
}
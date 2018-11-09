/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Cashier.StudentInfo;

import Controllers.GeneralPaymentController;
import Controllers.StudentTransactionController;
import Models.GeneralPayment;
import Models.Student;
import Models.StudentTransaction;
import Section.AnimationSection;
import Section.DesignSection;
import Section.StationSection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Eunar B. Dayangco
 */
public class StudentBalances extends javax.swing.JFrame {

    /**
     * Creates new form StudentBalances
     */
 
    private ViewStudentInfoUI viewstudentInfo;
    
    public StudentBalances() {
        initComponents();
        designComponents();
        
    }
    
    public StudentBalances(ViewStudentInfoUI viewstudentInfo) {
        initComponents();
        designComponents();
        this.viewstudentInfo = viewstudentInfo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        balancesPanel = new javax.swing.JPanel();
        balancesScrollPane = new javax.swing.JScrollPane();
        balancesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nameDisplayer = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        closebtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        balancesPanel.setBackground(new java.awt.Color(161, 214, 226));
        balancesPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        balancesPanel.setLayout(null);

        balancesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fee", "Balance"
            }
        ));
        balancesScrollPane.setViewportView(balancesTable);

        balancesPanel.add(balancesScrollPane);
        balancesScrollPane.setBounds(30, 120, 400, 290);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NAME:");
        balancesPanel.add(jLabel1);
        jLabel1.setBounds(30, 80, 50, 17);

        nameDisplayer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameDisplayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameDisplayer.setText("Eunar B. Dayangco");
        nameDisplayer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        balancesPanel.add(nameDisplayer);
        nameDisplayer.setBounds(90, 70, 340, 40);

        jPanel1.setBackground(new java.awt.Color(25, 149, 173));
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
        closebtn.setBounds(410, 0, 50, 40);

        balancesPanel.add(jPanel1);
        jPanel1.setBounds(0, 0, 460, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(balancesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(balancesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtnMouseClicked
        new AnimationSection().framesMoveBacktoTop(this, 70, 20);
    }//GEN-LAST:event_closebtnMouseClicked

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
            java.util.logging.Logger.getLogger(StudentBalances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentBalances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentBalances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentBalances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentBalances().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel balancesPanel;
    private javax.swing.JScrollPane balancesScrollPane;
    private javax.swing.JTable balancesTable;
    private javax.swing.JLabel closebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameDisplayer;
    // End of variables declaration//GEN-END:variables

    public void designComponents(){
               
        new DesignSection().designForm(this, balancesPanel, "mini");
        new DesignSection().designTable(balancesTable, balancesScrollPane);
        JTableHeader header = balancesTable.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 14));
          
        header.setBackground(new Color(25,149,173));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(0,30));
    }
    
     public void displayOnTable(){
        
           Student currentStudent = this.viewstudentInfo.getDisplayedStudent();
           
           nameDisplayer.setText(currentStudent.getFullname());
           
           int studentID = currentStudent.getStudentID();
           String grade = currentStudent.getLevel();
           String schoolYear= StationSection.getCurrentSchoolYear().getSchoolYearName();
           
           
           ArrayList<GeneralPayment> generalPayments = 
                   new GeneralPaymentController().getPaymentsFromGrade(grade);
           
           ArrayList<StudentTransaction> allTransaction = new ArrayList<>();
       
            
            for(GeneralPayment payment:generalPayments){
                
                 
                 StudentTransaction transaction = new StudentTransactionController().
                         getLatestTransaction(studentID, payment.getPaymentID(), schoolYear);
                         
                 
                 allTransaction.add(transaction);
                 
            }
            
            
           
        DefaultTableModel model = (DefaultTableModel)balancesTable.getModel();
          
        model.setRowCount(0);
          Object[] row = new Object[2];
          for(StudentTransaction transaction:allTransaction){
              
              row[0] = transaction.getPaymentFor().getPaymentName();
              row[1] = transaction.getRemainingBalance();
              model.addRow(row);
          }
  
    }
}
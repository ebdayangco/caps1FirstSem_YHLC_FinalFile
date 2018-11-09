/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Cashier.Transaction;

import Controllers.SchoolTransactionController;
import Models.SchoolTransaction;
import Section.AnimationSection;
import Section.CreateSection;
import Section.DesignSection;
import Section.StationSection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eunar B. Dayangco
 */
public class SchoolTransactionEntries extends javax.swing.JFrame {

    /**
     * Creates new form SchoolTransactionEntries
     */
    
    private OtherEntries entries;
    private ArrayList <SchoolTransaction> transactionEntries;
    private String message;
    
    public SchoolTransactionEntries() {
        initComponents();
        init();
    }
    public SchoolTransactionEntries( OtherEntries entries) {
        initComponents();
        this.entries = entries;
        init();
        
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OtherEntries getEntries() {
        return entries;
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
        closebtn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        for_comp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        amount_comp = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        type_comp = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        eachScrollPane = new javax.swing.JScrollPane();
        eachTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        voucher_comp = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        totalAmountDisplay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        remarks_comp = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        mainPanel.setBackground(new java.awt.Color(255, 240, 165));
        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(254, 175, 57));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        closebtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Galleries/xbutton.png"))); // NOI18N
        closebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closebtnMouseClicked(evt);
            }
        });
        jPanel2.add(closebtn);
        closebtn.setBounds(980, 0, 40, 40);

        mainPanel.add(jPanel2);
        jPanel2.setBounds(0, 0, 1020, 40);

        jPanel1.setBackground(new java.awt.Color(254, 175, 57));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD ENTRY");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 40, 190, 29);

        for_comp.setBackground(new java.awt.Color(204, 153, 0));
        for_comp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        for_comp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        for_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(for_comp);
        for_comp.setBounds(40, 120, 360, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TYPE:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 250, 70, 30);

        amount_comp.setBackground(new java.awt.Color(204, 153, 0));
        amount_comp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        amount_comp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amount_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(amount_comp);
        amount_comp.setBounds(40, 200, 360, 40);

        addbtn.setBackground(new java.awt.Color(0, 153, 0));
        addbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addbtn.setText("ADD");
        addbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel1.add(addbtn);
        addbtn.setBounds(260, 280, 150, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("FOR:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 90, 40, 30);

        type_comp.setBackground(new java.awt.Color(204, 153, 0));
        type_comp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        type_comp.setForeground(new java.awt.Color(0, 0, 0));
        type_comp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH-IN", "CASH-OUT" }));
        jPanel1.add(type_comp);
        type_comp.setBounds(40, 280, 180, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("AMOUNT:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 170, 70, 30);

        mainPanel.add(jPanel1);
        jPanel1.setBounds(30, 60, 440, 370);

        eachTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOR", "AMOUNT", "TYPE"
            }
        ));
        eachScrollPane.setViewportView(eachTable);

        mainPanel.add(eachScrollPane);
        eachScrollPane.setBounds(500, 120, 480, 240);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("VOUCHER #");
        mainPanel.add(jLabel3);
        jLabel3.setBounds(500, 70, 90, 30);

        voucher_comp.setBackground(new java.awt.Color(204, 153, 0));
        voucher_comp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        voucher_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mainPanel.add(voucher_comp);
        voucher_comp.setBounds(600, 70, 380, 40);

        jButton3.setBackground(new java.awt.Color(0, 153, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.add(jButton3);
        jButton3.setBounds(500, 490, 140, 40);

        savebtn.setBackground(new java.awt.Color(0, 153, 0));
        savebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        savebtn.setText("SAVE");
        savebtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        mainPanel.add(savebtn);
        savebtn.setBounds(500, 540, 140, 40);

        totalAmountDisplay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalAmountDisplay.setForeground(new java.awt.Color(0, 0, 0));
        totalAmountDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAmountDisplay.setText("0.00");
        totalAmountDisplay.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.add(totalAmountDisplay);
        totalAmountDisplay.setBounds(780, 490, 200, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("TOTAL:");
        mainPanel.add(jLabel4);
        jLabel4.setBounds(720, 490, 60, 40);

        remarks_comp.setBackground(new java.awt.Color(204, 153, 0));
        remarks_comp.setColumns(20);
        remarks_comp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        remarks_comp.setRows(5);
        remarks_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane3.setViewportView(remarks_comp);

        mainPanel.add(jScrollPane3);
        jScrollPane3.setBounds(500, 390, 480, 90);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("REMARKS:");
        mainPanel.add(jLabel8);
        jLabel8.setBounds(500, 360, 90, 20);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 1020, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtnMouseClicked
        new AnimationSection().framesMoveBacktoTop(this, 70, 20);
    }//GEN-LAST:event_closebtnMouseClicked

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        if(validateInput()){
            CreateSection.displayInfoMessage("Field Validation", getMessage());
        }else{
            transactionEntries.add(getSchoolTransactionEntry());
            displayOnTable();
        }
    }//GEN-LAST:event_addbtnActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        
        if(getVoucherNumberVal().isEmpty()){
            CreateSection.displayInfoMessage("Field Validation", "Please enter voucher number first.");
        }else if(getRemarksVal().isEmpty()){
            CreateSection.displayInfoMessage("Field Validation", "Please type remarks.");
        }else{
            new SchoolTransactionController().insertProcess(this);
        }
        
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
            java.util.logging.Logger.getLogger(SchoolTransactionEntries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchoolTransactionEntries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchoolTransactionEntries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchoolTransactionEntries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchoolTransactionEntries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JTextField amount_comp;
    private javax.swing.JLabel closebtn;
    private javax.swing.JScrollPane eachScrollPane;
    private javax.swing.JTable eachTable;
    private javax.swing.JTextField for_comp;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextArea remarks_comp;
    private javax.swing.JButton savebtn;
    private javax.swing.JLabel totalAmountDisplay;
    private javax.swing.JComboBox<String> type_comp;
    private javax.swing.JTextField voucher_comp;
    // End of variables declaration//GEN-END:variables

    public void init(){
         
        new DesignSection().designForm(this, mainPanel, "mini");
        new DesignSection().designTable(eachTable, eachScrollPane);
        this.transactionEntries = new ArrayList<>();
    }

    public ArrayList<SchoolTransaction> getTransactionEntries() {
        return transactionEntries;
    }

    public void setTransactionEntries(ArrayList<SchoolTransaction> transactionEntries) {
        this.transactionEntries = transactionEntries;
    }
    
    
    
    public SchoolTransaction getSchoolTransactionEntry(){
        SchoolTransaction entry = new SchoolTransaction();
     
        entry.setTransfor(for_comp.getText());
        entry.setAmount(Double.parseDouble(amount_comp.getText()));
        entry.setTransType(type_comp.getSelectedItem().toString());
        entry.setUser(StationSection.getLoggedUser());
      
        
        return entry;
        
    }
    
    public void displayOnTable(){
        
        double totalAmount = 0;
       
        
        DefaultTableModel model = (DefaultTableModel)eachTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        for(SchoolTransaction transaction:transactionEntries){
            row[0] = transaction.getTransfor();
            row[1] = transaction.getAmount();
            totalAmount+=transaction.getAmount();
            row[2] = transaction.getTransType();
            model.addRow(row);
        }
        totalAmountDisplay.setText(totalAmount+"");
        
        clearAll();
        
        
    }
    
    public boolean validateInput(){
        String displayedMessage = "";
        
        String forVal = for_comp.getText();
        String amountVal = amount_comp.getText();
        
        if(forVal.isEmpty()){
            displayedMessage+="Please enter FOR field.\n";
        }
       if(amountVal.isEmpty()){
            displayedMessage+="Please enter AMOUNT field.\n";
        }
       
        setMessage(displayedMessage);
        
        
        return forVal.isEmpty() || amountVal.isEmpty();
    
    }
    
    public void clearAll(){
        for_comp.setText("");
        amount_comp.setText("");
        type_comp.setSelectedIndex(0);
        voucher_comp.setText("");
        remarks_comp.setText("");
    }
    
    public String getVoucherNumberVal(){
        return voucher_comp.getText();
    }

    public String getRemarksVal(){
        return remarks_comp.getText();
    }

}